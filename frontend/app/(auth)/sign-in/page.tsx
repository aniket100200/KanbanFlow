import { SignInForm } from "@/app/(auth)/sign-in/sign-in-form";
import { Logo } from "@/components/logo";
import Link from "next/link";

const SignInPage = () => {
  return (
    <div className="w-full h-full flex flex-col items-center gap-4 justify-center border px-12 border-gray-100 rounded-2xl">
      <div className="flex w-full justify-center items-center gap-2">
        <Logo className="size-6" />
        <h4 className="uppercase font-bold text-lg tracking-tight">
          kanban flow
        </h4>
      </div>
      <p className="text-2xl font-normal tracking-tight mx-auto">
        Welcome to Kanban flow
      </p>
      <p className="text-neutral-500 text-pretty text-center">
        Organize your work, track progress, and stay focused. Your tasks, teams,
        and timelines all in one simple, powerful workspace.
      </p>
      <SignInForm />
      <Link href="../sign-up">
        <p className="text-blue-400 underline">Don't have an account?</p>
      </Link>
    </div>
  );
};
export default SignInPage;
