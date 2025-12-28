"use server";
import { cookies } from "next/headers";

const baseUrl = process.env.NEXT_PUBLIC_BACKEND_URL;

export async function registerUser(formData: any) {
  const res = await fetch(`${baseUrl}/user/create`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });

  if (!res.ok) throw new Error("Failed to register");
  return await res.json();
}

export async function loginUser(formData: any) {
  const res = await fetch(`${baseUrl}/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });

  if (!res.ok) throw new Error("Failed to register");

  const setCookieHeader = res.headers.get("set-cookie");

  if (setCookieHeader) {
    const cookieStore = await cookies();

    const tokenValue = setCookieHeader.split(";")[0].split("=")[1];

    cookieStore.set("token", tokenValue, {
      httpOnly: true,
      secure: process.env.NODE_ENV === "production",
      path: "/",
      maxAge: 3 * 24 * 60 * 60, // Match your Spring Boot 3-day logic
    });
  }
  return await res.json();
}

export async function getAllBoards() {
  const res = await fetch(`${baseUrl}/board/getAll`);

  if (!res.ok) throw new Error("Failed to getAllBoards");

  return await res.json();
}

export async function createBoard(boardTitle: string) {
  const res = await fetch(`${baseUrl}/board/create`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name: boardTitle }),
  });

  if (!res.ok) throw new Error("Failed to create board");
  return await res.json();
}
