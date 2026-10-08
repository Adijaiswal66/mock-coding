import { useState } from "react";
import { Outlet } from "react-router-dom";
import { Box, useMediaQuery, useTheme } from "@mui/material";
import AppHeader from "./AppHeader.jsx";
import SideNavigation from "./SideNavigation.jsx";

const DRAWER_WIDTH = 256;

export default function AppShell({ children }) {
  const theme = useTheme();
  const isDesktop = useMediaQuery(theme.breakpoints.up("md"));
  const [mobileNavigationOpen, setMobileNavigationOpen] = useState(false);

  const closeMobileNavigation = () => setMobileNavigationOpen(false);

  return (
    <Box sx={{ display: "flex", minHeight: "100vh", bgcolor: "grey.50" }}>
      <AppHeader
        drawerWidth={DRAWER_WIDTH}
        onMenuClick={() => setMobileNavigationOpen(true)}
      />
      <SideNavigation
        drawerWidth={DRAWER_WIDTH}
        isDesktop={isDesktop}
        mobileOpen={mobileNavigationOpen}
        onClose={closeMobileNavigation}
      />
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          minWidth: 0,
          p: { xs: 2, sm: 3, md: 4 },
          mt: 8,
          ml: { md: `${DRAWER_WIDTH}px` },
        }}
      >
        {children ?? <Outlet />}
      </Box>
    </Box>
  );
}
