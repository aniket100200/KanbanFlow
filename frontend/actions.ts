"use server";

export async function registerUser(formData: any) {
  const baseUrl = process.env.NEXT_PUBLIC_BACKEND_URL;

  const res = await fetch(`${baseUrl}/user/create`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });

  if (!res.ok) throw new Error("Failed to register");
  return await res.json();
}

export async function loginUser(formData: any) {
  const baseUrl = process.env.NEXT_PUBLIC_BACKEND_URL;
  console.log(baseUrl);
  const res = await fetch(`${baseUrl}/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(formData),
  });

  if (!res.ok) throw new Error("Failed to register");
  return await res.json();
}
