"use client";
import { ChevronDown, PanelsTopLeft } from "lucide-react";
import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarHeader,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar";

import {
  Collapsible,
  CollapsibleContent,
  CollapsibleTrigger,
} from "@/components/ui/collapsible";

import { Logo } from "@/components/logo";
import { cn } from "@/lib/utils";
import { useState } from "react";
import Link from "next/link";

// Menu items.
const navigateItems = [
  {
    title: "Boards",
    icon: PanelsTopLeft,
    dropdown: true,
    url: "",
    href: "/boards",
  },
];

export function AppSidebar() {
  const [openMenu, setOpenMenu] = useState<string | null>(null);

  const [boards, setBoards] = useState([
    "Notification panel",
    "Watcher project",
  ]);

  return (
    <Sidebar>
      <SidebarHeader>
        <div
          className={cn(
            "flex h-full items-center gap-2 rounded-md p-1.5",
            "hover:bg-sidebar-accent"
          )}
        >
          <div className="size-8">
            <Logo className="h-full w-full" />
          </div>
          <p className="text-lg font-semibold tracking-tight">Kanban flow</p>
        </div>
      </SidebarHeader>
      <SidebarContent>
        <SidebarGroup>
          <SidebarGroupLabel>Navigate</SidebarGroupLabel>
          <SidebarGroupContent>
            <SidebarMenu>
              {navigateItems.map((item) => {
                const { title, icon: Icon, dropdown, url, href } = item;
                return (
                  <SidebarMenuItem key={title}>
                    {url ? (
                      <SidebarMenuButton asChild>
                        <a href={url}>
                          <Icon />
                          <span>{title}</span>
                        </a>
                      </SidebarMenuButton>
                    ) : dropdown ? (
                      <Collapsible
                        open={openMenu === title}
                        onOpenChange={(open) =>
                          setOpenMenu(open ? title : null)
                        }
                      >
                        <CollapsibleTrigger asChild>
                          <SidebarMenuButton>
                            <Icon />
                            <span>{title}</span>
                            <div className="flex flex-1 items-center justify-end">
                              <ChevronDown
                                className={cn(
                                  "size-4 text-neutral-500 transition-all",
                                  openMenu === title ? "rotate-180" : ""
                                )}
                              />
                            </div>
                          </SidebarMenuButton>
                        </CollapsibleTrigger>
                        <CollapsibleContent>
                          <ul className="border-sidebar-border mx-3.5 flex min-w-0 translate-x-px flex-col gap-1 border-l px-2.5 py-0.5">
                            {boards &&
                              boards.map((b, idx) => (
                                <li
                                  key={`board_${b.toLowerCase()}`}
                                  className="flex h-7 w-full items-center"
                                >
                                  <Link
                                    href={href}
                                    className="flex h-full w-full items-center rounded-md px-2 py-1.5 text-sm hover:bg-neutral-200/50"
                                  >
                                    {b}
                                  </Link>
                                </li>
                              ))}
                          </ul>
                        </CollapsibleContent>
                      </Collapsible>
                    ) : (
                      <SidebarMenuButton>
                        <Icon />
                        <span>{title}</span>
                      </SidebarMenuButton>
                    )}
                  </SidebarMenuItem>
                );
              })}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  );
}
