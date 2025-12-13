import { Wrapper } from "@/components/wrapper";

function AuthLayout({ children }: { children: React.ReactNode }) {
  return (
    <Wrapper>
      <div className="h-full w-full flex gap-4 items-center justify-center">
        {children}
        <div className="bg-neutral-300 border border-gray-100 bg-linear-to-b from-white to-neutral-100 rounded-2xl h-full w-full"></div>
      </div>
    </Wrapper>
  );
}
export default AuthLayout;
