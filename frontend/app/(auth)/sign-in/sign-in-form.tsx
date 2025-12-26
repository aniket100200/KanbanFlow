"use client";

import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { z } from "zod";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import {
  InputGroup,
  InputGroupAddon,
  InputGroupInput,
} from "@/components/ui/input-group";
import { LockKeyhole, Mail } from "lucide-react";
import { Button } from "@/components/ui/button";
import { useRouter } from "next/navigation";
import { loginUser } from "@/actions";
import { toast } from "sonner";

const formSchema = z.object({
  email: z.email(),
  password: z.string().min(2, {
    message: "please enter a password",
  }),
});

export const SignInForm = () => {
  const router = useRouter();
  // 1. Define your form.
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      email: "",
      password: "",
    },
  });

  // 2. Define a submit handler.
  async function onSubmit({ email, password }: z.infer<typeof formSchema>) {
    try {
      await loginUser({ email, password });
      router.push("/dashboard");
    } catch (err) {
      toast.message("Please enter a valid email or password", {
        description: new Date().toLocaleString("en-US", {
          weekday: "short", // Mon
          year: "numeric",
          month: "short", // Sep
          day: "numeric",
          hour: "2-digit",
          minute: "2-digit",
          second: "2-digit",
        }),
      });
    }
  }

  return (
    <Form {...form}>
      <form
        onSubmit={form.handleSubmit(onSubmit)}
        className="mt-2 w-full space-y-8"
      >
        <FormField
          control={form.control}
          name="email"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Email</FormLabel>
              <FormControl>
                <InputGroup className="rounded-4xl">
                  <InputGroupInput
                    type={"email"}
                    placeholder="your@email.com"
                    className="h-8"
                    {...field}
                  />
                  <InputGroupAddon>
                    <Mail />
                  </InputGroupAddon>
                </InputGroup>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Password</FormLabel>
              <FormControl>
                <InputGroup className="rounded-4xl">
                  <InputGroupInput
                    className="h-8"
                    type={"password"}
                    placeholder="*********"
                    {...field}
                  />
                  <InputGroupAddon>
                    <LockKeyhole />
                  </InputGroupAddon>
                </InputGroup>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <Button type={"submit"} className="w-full rounded-4xl" size={"lg"}>
          Sign in
        </Button>
      </form>
    </Form>
  );
};
export default SignInForm;
