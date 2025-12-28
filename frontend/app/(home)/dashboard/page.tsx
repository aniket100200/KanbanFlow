import { Clock, LayoutPanelTop, PlusIcon } from "lucide-react";
import Image from "next/image";
import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { createBoard } from "@/actions";
import { toast } from "sonner";

const Dashboard = async () => {
  // const allBoards = await getAllBoards();

  return (
    <div className="flex h-full w-full flex-col gap-4 p-6">
      <div className="flex h-10 w-full items-center">
        <div className="ml-auto">
          <Dialog>
            <DialogTrigger asChild>
              <Button className="rounded-full">
                <PlusIcon className="size-4" />
                Create Board
              </Button>
            </DialogTrigger>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>Create Board</DialogTitle>
              </DialogHeader>
              <div className="flex flex-1 flex-col gap-2">
                <Label htmlFor="boardname">Board title</Label>
                <Input
                  id="board_name"
                  name="boardname"
                  placeholder="Your board name"
                />
              </div>
              <DialogFooter>
                <Button
                  className="rounded-md"
                  onClick={() => handleOnCreateBoard("")}
                >
                  Create
                </Button>
              </DialogFooter>
            </DialogContent>
          </Dialog>
        </div>
      </div>
      <div className="flex flex-1 flex-col gap-8">
        <div className="flex flex-col gap-2">
          <div className="flex items-center gap-2">
            <LayoutPanelTop className="size-5 text-neutral-800" />
            <p className="text-xl font-bold tracking-tight text-neutral-800">
              Most popular templates
            </p>
          </div>
          <p className="text-sm font-medium text-neutral-500">
            Get going faster with a template from the KanbanFlow community
          </p>
          <div className="mt-2 flex items-center gap-4">
            <Card
              cardImage="https://cdn.pixabay.com/photo/2025/05/31/23/07/trees-9634372_1280.png"
              cardTitle="KanbanFlow Template"
              isTemplate={true}
            />
            <Card
              cardImage="https://cdn.pixabay.com/photo/2025/07/02/13/20/thread-9692407_1280.png"
              cardTitle="Tasklist Template"
              isTemplate={true}
            />
          </div>
        </div>
        <div className="flex flex-col justify-center gap-2">
          <div className="flex items-center gap-2">
            <Clock className="size-5 text-neutral-800" />
            <p className="text-lg font-bold tracking-tight text-neutral-800">
              Recently viewed
            </p>
          </div>
          <div className="mt-2 flex items-center gap-4">
            <Card
              cardImage="https://cdn.pixabay.com/photo/2025/05/31/23/07/trees-9634372_1280.png"
              cardTitle="KanbanFlow Template"
              isTemplate={true}
            />
            <Card
              cardImage="https://cdn.pixabay.com/photo/2025/07/02/13/20/thread-9692407_1280.png"
              cardTitle="Watchers Board"
            />
            <Card
              cardImage="https://cdn.pixabay.com/photo/2023/10/14/09/19/meditation-8314420_1280.png"
              cardTitle="Meditation Board"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

function Card({
  cardImage,
  cardTitle,
  isTemplate = false,
}: {
  cardImage: string;
  cardTitle: string;
  isTemplate?: boolean;
}) {
  return (
    <div className="cursor-pointer overflow-hidden rounded-md border border-neutral-200 ring-1 shadow-[rgba(0,_0,_0,_0.2)_0px_60px_40px_-7px] ring-neutral-200">
      <div className="relative h-24 w-52">
        <Image
          src={cardImage}
          alt={`${cardTitle}_image`}
          width={600}
          height={600}
          className="h-full w-full object-cover"
        />
        {isTemplate && (
          <span className="absolute right-1 bottom-1 rounded bg-neutral-200 p-1 text-[10px] font-medium text-neutral-800 uppercase">
            template
          </span>
        )}
      </div>
      <p className="p-2 text-xs font-medium text-neutral-800">{cardTitle}</p>
    </div>
  );
}

async function handleOnCreateBoard(boardName: string) {
  const res = await createBoard(boardName);
  if (res.status === 200) {
    toast.success("Board successfully created!");
  } else {
    toast.error("Error while creating board!");
  }
}

export default Dashboard;
