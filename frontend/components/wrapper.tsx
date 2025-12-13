import { cn } from "@/lib/utils";

export const Wrapper = ({
  children,
  className,
}: {
  children: React.ReactNode;
  className?: string;
}) => {
  return (
    <div
      className={cn("max-w-7xl h-screen w-full mx-auto py-2 px-4", className)}
    >
      {children}
    </div>
  );
};
