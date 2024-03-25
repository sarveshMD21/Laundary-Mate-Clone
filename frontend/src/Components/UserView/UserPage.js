import React from 'react'
import { Box } from '@mui/material'
import Navbar from './Navbar'
import OptionCart from './OptionCart'
import {Container} from '@mui/material'
import Grid from '@mui/material/Grid';
const UserPage = () => {
  return (
    <Box sx={{height:"100vh",width:"80vw"}}>
        <Grid container rowSpacing={1} sx={{height:"100vh",width:"80vw"}} direction="column">
            <Grid item sx={{height:"20%" , width:"80vw"}}>
                <Navbar/>
            </Grid>
            <Grid item sx={{ height: '80%',width:"80vw",justifyContent: 'center'}}>
                <OptionCart/>
            </Grid>
        </Grid>
   </Box>
  )
}

export default UserPage