package jwtexample3.example.kanbanflow.service.Imp;

import jakarta.servlet.http.HttpSession;
import jwtexample3.example.kanbanflow.customExceptions.BoardNotFoundException;
import jwtexample3.example.kanbanflow.customExceptions.UserNotFoundException;
import jwtexample3.example.kanbanflow.dtos.request.BoardRequestDao;
import jwtexample3.example.kanbanflow.dtos.response.BoardResponseDao;
import jwtexample3.example.kanbanflow.models.Board;
import jwtexample3.example.kanbanflow.models.TaskColumn;
import jwtexample3.example.kanbanflow.models.User;
import jwtexample3.example.kanbanflow.repository.BoardRepository;
import jwtexample3.example.kanbanflow.repository.UserRepository;
import jwtexample3.example.kanbanflow.service.BoardService;
import jwtexample3.example.kanbanflow.transformers.BoardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImp implements BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    HttpSession session;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public BoardServiceImp(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public void deleteBoard(String boardUuid) {
        Optional<Board> optional = boardRepository.findById(boardUuid);
        if(optional.isPresent())boardRepository.deleteById(boardUuid);
        else throw new BoardNotFoundException("Board not found");

    }

    @Override
    public BoardResponseDao createBoard(BoardRequestDao requestDao) {
        Board board = BoardTransformer.boardRequestDaoToBoard(requestDao);
        try{
            User sessionUser = (User) session.getAttribute("user");
            if(sessionUser==null) throw new UserNotFoundException("User not found");
            board.setOwnerId(sessionUser.getId());
            board.setUser(sessionUser);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        //you'll have to set User.
        Optional<User> optional = userRepository.findById(requestDao.getOwnerId());

        if(optional.isEmpty())throw new UserNotFoundException("User not found");

        //set User
        User user = optional.get();
        if(board.getUser()!=null)
        board.setUser(user);

        //Set columns
        board.setColumns(new ArrayList<TaskColumn>());

        boardRepository.save(board);

        return BoardTransformer.boardToBoardResponseDao(board);
    }

    @Override
    public BoardResponseDao updateBoard(BoardRequestDao requestDao, String boardUuid) {
        Board board = boardRepository.findById(boardUuid).orElseThrow();
        if(requestDao.getName()!=null)board.setName(requestDao.getName());
        if(requestDao.getOwnerId()!=null)board.setOwnerId(requestDao.getOwnerId());

        Optional<User> optional = userRepository.findById(requestDao.getUserId());

        if(optional.isEmpty())throw new UserNotFoundException("User not found");
        User user = optional.get();
        board.setUser(user);

        board = boardRepository.save(board);

        return BoardTransformer.boardToBoardResponseDao(board);
    }

    @Override
    public BoardResponseDao getBoard(String boardUuid) {
        Board board = boardRepository.findById(boardUuid).orElseThrow();

        return BoardTransformer.boardToBoardResponseDao(board);
    }

    @Override
    public List<BoardResponseDao> getAllBoards(String userUuid) {
        Optional<User> optional = userRepository.findById(userUuid);
        if(optional.isEmpty())throw new UserNotFoundException("User not found");
        User user = optional.get();
        return user.getBoards().stream().map(BoardTransformer::boardToBoardResponseDao).collect(Collectors.toList());
    }
}
