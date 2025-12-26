import { NextRequest, NextResponse } from "next/server";

export function middleware(req: NextRequest, res: NextResponse) {
  const token = req.cookies.get("access_token");
  const protectedRoutes = ["/", "/dashboard", "/board"];

  if (
    protectedRoutes.some((route) => req.nextUrl.pathname.startsWith(route)) &&
    !token
  ) {
    return NextResponse.redirect(new URL("/sign-in", req.url));
  }

  return NextResponse.next();
}
