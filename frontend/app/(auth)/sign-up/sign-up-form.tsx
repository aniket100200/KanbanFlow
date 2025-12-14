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
import { registerUser } from "@/actions";

const formSchema = z
  .object({
    firstName: z.string().min(2),
    lastName: z.string().min(2),
    email: z.string().email(),
    password: z.string().min(2, {
      message: "please enter a password",
    }),
    confirmPassword: z.string(),
  })
  .refine((data) => data.password === data.confirmPassword, {
    message: "Passwords do not match",
    path: ["confirmPassword"], // This attaches the error to the confirm field
  });

export const SignUpForm = () => {
  // 1. Define your form.
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      confirmPassword: "",
    },
  });

  // 2. Define a submit handler.
  async function onSubmit({
    firstName,
    lastName,
    email,
    password,
  }: z.infer<typeof formSchema>) {
    try {
      const user = {
        firstName,
        lastName,
        email,
        password,
        phone: "9879874565",
      };

      await registerUser(user);
    } catch (error) {
      console.error("Failed to submit:", error);
    }
  }

  return (
    <Form {...form}>
      <form
        onSubmit={form.handleSubmit(onSubmit)}
        className="space-y-8 w-full mt-2"
      >
        <FormField
          control={form.control}
          name="firstName"
          render={({ field }) => (
            <FormItem>
              <FormLabel>First Name</FormLabel>
              <FormControl>
                <InputGroup className="rounded-4xl">
                  <InputGroupInput
                    type={"text"}
                    placeholder="John"
                    className="h-8"
                    {...field}
                  />
                </InputGroup>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="lastName"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Last Name</FormLabel>
              <FormControl>
                <InputGroup className="rounded-4xl">
                  <InputGroupInput
                    type={"text"}
                    placeholder="wick"
                    className="h-8"
                    {...field}
                  />
                </InputGroup>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
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
        <FormField
          control={form.control}
          name="confirmPassword"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Confirm Password</FormLabel>
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
          Sign up
        </Button>
      </form>
    </Form>
  );
};
