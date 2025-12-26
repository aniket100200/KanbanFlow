"use client";

import { useParams } from "next/navigation";
import { Button } from "@/components/ui/button";
import {
  CircleDashed,
  EllipsisVertical,
  MessageSquareText,
  Paperclip,
  PlusIcon,
} from "lucide-react";
import { cn } from "@/lib/utils";
import {
  Tooltip,
  TooltipContent,
  TooltipTrigger,
} from "@/components/ui/tooltip";

function BoardPage() {
  const { id } = useParams();
  const backgroundImages = [
    "https://cdn.pixabay.com/photo/2017/02/01/17/59/mountains-2031539_1280.jpg", // Scenic mountains
    "https://cdn.pixabay.com/photo/2015/10/12/15/45/table-984635_1280.jpg", // Soft nature background
    "https://cdn.pixabay.com/photo/2016/11/29/03/53/sakura-1867454_1280.jpg", // Beautiful blossoms
    "https://cdn.pixabay.com/photo/2018/01/17/07/51/sea-3082832_1280.jpg", // Calm beach/sea
    "https://cdn.pixabay.com/photo/2019/10/23/14/18/forest-4568855_1280.jpg", // Dense forest scenery
  ];

  return (
    <div className="flex h-full w-full flex-col gap-4 p-6">
      <BoardHeader />
      <div
        className={cn(
          "grid w-full flex-1 gap-4 rounded-md px-2 py-1.5",
          "grid-cols-[repeat(auto-fit,280px)] bg-neutral-50",
          "bg-cover bg-center"
        )}
      >
        <BoardColumn />
        <BoardColumn />
      </div>
    </div>
  );
}

function BoardHeader() {
  return (
    <div className="flex w-full items-center justify-between">
      <h4 className="text-2xl font-bold tracking-tight text-neutral-800">
        Board Name
      </h4>
      <Button className="rounded-full text-xs">
        <PlusIcon className="size-5" />
        Add List / Column
      </Button>
    </div>
  );
}

function BoardColumn() {
  return (
    <div className="flex h-full flex-col gap-2 rounded-md border border-neutral-200 bg-white p-2">
      <BoardColumnHeader />
      <BoardColumnCard />
    </div>
  );
}

function BoardColumnHeader() {
  return (
    <div className="flex items-center justify-between">
      <div className="flex items-center gap-2">
        <CircleDashed className="size-5" />
        <p className="text-sm font-medium text-neutral-700">Todo</p>
      </div>
      <div className="flex items-center gap-2">
        <div
          className={cn(
            "flex items-center justify-center rounded-md",
            "size-5 p-3 text-xs font-medium",
            "border border-neutral-300"
          )}
        >
          8
        </div>
        <Tooltip>
          <TooltipTrigger asChild>
            <Button className="size-7 rounded-full active:scale-90">
              <PlusIcon className="size-4" />
            </Button>
          </TooltipTrigger>
          <TooltipContent>
            <p>Add card</p>
          </TooltipContent>
        </Tooltip>
      </div>
    </div>
  );
}

function BoardColumnCard() {
  return (
    <div className="rounded-md border border-neutral-200">
      <div className="flex w-full flex-col gap-2 p-2">
        <div className="flex items-center justify-between gap-2">
          <div className="flex flex-col gap-0.5">
            <h4 className="text-sm font-semibold tracking-tight text-neutral-800">
              Card name
            </h4>
            <p className="text-[10px] font-medium tracking-tight text-neutral-500">
              Due in days
            </p>
          </div>
          <div
            className={cn(
              "flex h-fit items-center justify-center gap-1 rounded-2xl",
              "w-fit border border-red-400 bg-red-500/10 px-1 py-0.5 text-[10px] text-red-500"
            )}
          >
            <div className="size-2 rounded-full bg-red-400" />
            Delayed
          </div>
        </div>
        <div className="mt-1 w-full border-1 border-dashed border-neutral-200" />
      </div>
      <div className="p-2 pt-0">
        <p className="line-clamp-2 text-xs font-medium text-neutral-500">
          Implement the core functionality for this task. Ensure all
          requirements are met, edge cases are handled, and the feature is
          tested before moving to review.
        </p>
      </div>
      <div className="flex items-center justify-between border-t border-neutral-200 p-2">
        <div className="flex items-center gap-2">
          <div className="flex cursor-pointer items-center justify-center rounded-full border border-neutral-200 p-1">
            <Paperclip className="size-3 text-neutral-500" />
          </div>
          <div className="flex cursor-pointer items-center justify-center rounded-full border border-neutral-200 p-1">
            <MessageSquareText className="size-3 text-neutral-500" />
          </div>
        </div>

        <div className="flex cursor-pointer items-center justify-center rounded border border-neutral-200 p-1">
          <EllipsisVertical className="size-3 text-neutral-500" />
        </div>
      </div>
    </div>
  );
}

export default BoardPage;
