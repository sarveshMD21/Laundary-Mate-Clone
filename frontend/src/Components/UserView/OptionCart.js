import React from 'react'
import Paper from '@mui/material/Paper'
import { Box } from '@mui/material';
import Grid from '@mui/material/Grid';
import OptionClothe from './OptionClothe';
import Button from '@mui/material/Button';
import Catalouge from './Catalouge';
import { useState } from 'react';

const OptionCart = () => {
    const [totalCost,setTotalCost]=useState(0);

   return (
//     <div>hi</div>
    <Box sx={{height:"70%",width:"70%"}}>
        <Box sx={{height:"70%",width:"70%"}}>
            <Paper sx={{height:"70%",width:"60%",position:"absolute",left:"17%" }} elevation={3}>
                <Grid container rowSpacing={1} sx={{height:"100%",width:"100%"}} direction="column">
                <Grid item sx={{height:"30%" , width:"100%"}}>
                   <OptionClothe/>
                </Grid>
                <Grid item sx={{height:"60%",width:"100%"}}>
                    <Catalouge totalCost={totalCost} setTotalCost={setTotalCost}/>
                </Grid>
                <Grid item sx={{height:"10%",width:"100%",display:"flex",justifyContent:"center"}}>
                <Button variant="contained">Create Order:₹ {totalCost}</Button>
                </Grid>
                </Grid>
            </Paper>
        </Box>
    </Box>
  )
}

export default OptionCart