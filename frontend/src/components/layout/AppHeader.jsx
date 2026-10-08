import { Link as RouterLink } from "react-router-dom";
import {
  AppBar,
  Box,
  Button,
  IconButton,
  Toolbar,
  Typography,
} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";

export default function AppHeader({ drawerWidth, onMenuClick }) {
  return (
    <AppBar
      position="fixed"
      color="inherit"
      elevation={0}
      sx={{
        borderBottom: 1,
        borderColor: "divider",
        zIndex: (theme) => theme.zIndex.drawer + 1,
      }}
    >
      <Toolbar sx={{ minHeight: 64 }}>
        <IconButton
          color="inherit"
          aria-label="Open navigation"
          onClick={onMenuClick}
          edge="start"
          sx={{ mr: 1, display: { md: "none" } }}
        >
          <MenuIcon />
        </IconButton>
        <Box
          sx={{
            width: { md: drawerWidth },
            display: "flex",
            alignItems: "center",
            flexShrink: 0,
          }}
        >
          <Typography variant="h6" component="div" fontWeight={700}>
            Mock Coding
          </Typography>
        </Box>
        <Box sx={{ flexGrow: 1 }} />
        <Button component={RouterLink} to="/login" color="primary">
          Sign in
        </Button>
      </Toolbar>
    </AppBar>
  );
}
