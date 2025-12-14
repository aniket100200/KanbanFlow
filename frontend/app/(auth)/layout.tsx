import { Wrapper } from "@/components/wrapper";
import Image from "next/image";

function AuthLayout({ children }: { children: React.ReactNode }) {
  return (
    <Wrapper>
      <div className="h-full w-full flex gap-4 items-center justify-center">
        {children}
        <div className="bg-neutral-300 overflow-hidden border border-gray-100 bg-linear-to-b from-white to-neutral-100 rounded-2xl h-full w-full">
          <Image
            src="https://cdn.pixabay.com/photo/2017/05/29/10/09/architecture-2353385_1280.jpg"
            alt="img"
            height="1080"
            width="500"
            className="w-full h-full"
          />
        </div>
      </div>
    </Wrapper>
  );
}
export default AuthLayout;
