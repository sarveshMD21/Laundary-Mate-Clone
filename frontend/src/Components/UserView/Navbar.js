import React from 'react'
import AppBar from '@mui/material/AppBar';
import { Box } from '@mui/material';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import Laundary from '../../Assets/laundry.png';
import CustomIcon from './CustomIcon';

const Navbar = () => {
  return (  
    <Box sx={{width:"100vw",height:"80%"}}>
        <AppBar sx={{background:"#e69b00"}}>
            <Toolbar>
            <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <CustomIcon  src={Laundary} height="30px" width="30px"/>
          </IconButton>
            
          
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 ,color:"#1520A6",fontWeight:"bold"}}>
            LaundaryMate
          </Typography>

            </Toolbar>
        </AppBar>
    </Box>
  )
}

export default Navbar