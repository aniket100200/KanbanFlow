import { NextRequest, NextResponse } from "next/server";

export function proxy(req: NextRequest, res: NextResponse) {
  const token = req.cookies.get("token")?.value;
  const { pathname } = req.nextUrl;

  const publicRoutes = ["/sign-in", "/sign-up", "/forgot-password"];
  const isPublicRoute = publicRoutes.some((route) =>
    pathname.startsWith(route)
  );

  if (!isPublicRoute && !token) {
    return NextResponse.redirect(new URL("/sign-in", req.url));
  }

  if (isPublicRoute && token) {
    return NextResponse.redirect(new URL("/dashboard", req.url));
  }

  return NextResponse.next();
}

export const config = {
  // This matcher ensures the proxy runs on every single page request
  // but ignores static files, images, and internal Next.js files
  matcher: ["/((?!api|_next/static|_next/image|favicon.ico).*)"],
};
