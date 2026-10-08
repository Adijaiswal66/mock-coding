import { NavLink } from "react-router-dom";
import {
  Box,
  Drawer,
  List,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Toolbar,
} from "@mui/material";
import DashboardOutlinedIcon from "@mui/icons-material/DashboardOutlined";
import GroupsOutlinedIcon from "@mui/icons-material/GroupsOutlined";
import { appRoutes } from "../../app/routes.jsx";

const navigationIcons = {
  "/dashboard": <DashboardOutlinedIcon />,
  "/employees": <GroupsOutlinedIcon />,
};

export default function SideNavigation({
  drawerWidth,
  isDesktop,
  mobileOpen,
  onClose,
}) {
  const drawerContent = (
    <Box sx={{ overflow: "auto", py: 2 }}>
      <List aria-label="Main navigation">
        {appRoutes.map(({ label, path }) => (
          <ListItemButton
            key={path}
            component={NavLink}
            to={path}
            onClick={onClose}
            sx={{
              mx: 1.5,
              mb: 0.5,
              borderRadius: 2,
              color: "text.secondary",
              "&.active": {
                color: "primary.main",
                bgcolor: "action.selected",
                "& .MuiListItemIcon-root": {
                  color: "primary.main",
                },
              },
            }}
          >
            <ListItemIcon sx={{ minWidth: 40 }}>
              {navigationIcons[path]}
            </ListItemIcon>
            <ListItemText primary={label} />
          </ListItemButton>
        ))}
      </List>
    </Box>
  );

  return (
    <Drawer
      variant={isDesktop ? "permanent" : "temporary"}
      open={isDesktop || mobileOpen}
      onClose={onClose}
      ModalProps={{ keepMounted: true }}
      sx={{
        width: { md: drawerWidth },
        flexShrink: 0,
        "& .MuiDrawer-paper": {
          width: drawerWidth,
          boxSizing: "border-box",
          borderRight: 1,
          borderColor: "divider",
        },
      }}
    >
      <Toolbar sx={{ minHeight: 64 }} />
      {drawerContent}
    </Drawer>
  );
}
