import React from 'react'
import Grid from '@mui/material/Grid';
import { useState } from 'react';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import CustomIcon from './CustomIcon';
import Laundary from '../../Assets/laundry.png';
import Typography from '@mui/material/Typography';
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import IconButton from '@mui/material/IconButton';

const Catalouge = (props) => {

    const [currentPage, setCurrentPage] = useState(1);
    const [currentCost,setCurrentCost]=useState(40);
    const boxesPerPage = 3;
  
    const totalPages = Math.ceil(10 / boxesPerPage);
  
    const handleNextPage = () => {
      setCurrentPage((prevPage) => Math.min(prevPage + 1, totalPages));
    };
  
    const handlePrevPage = () => {
      setCurrentPage((prevPage) => Math.max(prevPage - 1, 1));
    };
    const [boxCosts, setBoxCosts] = useState(Array.from({ length: 12 }, () => 0));

    const handleIncreaseCost = (boxIndex) => {
        setBoxCosts((prevCosts) => {
          const updatedCosts = [...prevCosts];
          updatedCosts[boxIndex] += 40; // Increase cost by 40 for the specific box
          props.setTotalCost(props.totalCost+40);
          return updatedCosts;
        });
      };
    
      const handleDecreaseCost = (boxIndex) => {
        setBoxCosts((prevCosts) => {
          const updatedCosts = [...prevCosts];
          updatedCosts[boxIndex] =Math.max(0,updatedCosts[boxIndex]-40); // Decrease cost by 40 for the specific box
          props.setTotalCost(Math.max(0,props.totalCost-40));
          return updatedCosts;
        });
      };
    

  return (
    <Grid container direction="column" sx={{height:"100%",width:"100%"}}>
        <Grid item sx={{height:"85%",width:"100%"}}>
            <Grid container sx={{height:"100%",width:"100%" , display:"flex",justifyContent:"center"}} direction="row">
            {Array.from({ length: boxesPerPage }).map((_, index) => {
          const boxNumber = (currentPage - 1) * boxesPerPage + index + 1;
          const boxIndex = boxNumber - 1;
          return (
            <Grid item xs={4}
              key={boxNumber}
              sx={{display:"flex",justifyContent:"center",alignItems:"center",height:"100%"}}
            >
             <Paper sx={{height:"80%",width:"80%"}} elevation={3}>
                 <Grid container sx={{height:"100%",width:"100%"}} direction="column">
                     <Grid item sx={{height:"80%",width:"100%"}}>
                       <Grid container sx={{height:"100%",width:"100%"}} direction="column">
                         <Grid item sx={{height:"90%",display:"flex",justifyContent:"center",alignItems:"center"}}>
                         <CustomIcon src={Laundary} height="100%" width="70%"/>
                         </Grid>
                         <Grid item sx={{height:"10%",display:"flex",justifyContent:"center"}}>
                         <Typography variant="body1" style={{ opacity: 0.5 }}>
                         ₹ 40
    </Typography>
                         </Grid>
                       </Grid>                        
                     </Grid>
                     <Grid item sx={{height:"20%",width:"100%"}}>
                        <Grid container sx={{height:"100%",width:"100%"}} direction="row">
                            <Grid item xs={4} sx={{display:"flex",justifyContent:"end"}}>
                            <IconButton
            size="small"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 ,position:"relative",left:"50%"}}
            onClick={()=>{handleIncreaseCost(boxIndex)}}
          >
            <AddIcon/>
          </IconButton>
                            </Grid>
                            <Grid item xs={4} sx={{display:"flex",justifyContent:"center"}}>
                            <Typography sx={{display:"flex",justifyContent:"center",alignItems:"center"}} >
                         ₹ {boxCosts[boxIndex]}
    </Typography>
                            </Grid>
                            <Grid item xs={4} sx={{display:"flex",justifyContent:"start"}}>
                            <IconButton
            size="small"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2,position:"relative",right:"25%" }}
            onClick={()=>{handleDecreaseCost(boxIndex)}}
          >
            <RemoveIcon/>
          </IconButton>
                            </Grid>
                        </Grid>
                     </Grid>
                 </Grid>
             </Paper>
            </Grid>
          );
        })}
            </Grid>
        </Grid>
        <Grid item sx={{height:"15%",width:"100%"}}>
            <Grid container direction="row" sx={{height:"100%",width:"100%",display:"flex",justifyContent:"center"}}>
                <Grid item xs={4} sx={{display:"flex" }}>
                <Button variant="contained" onClick={handlePrevPage} disabled={currentPage === 1} sx={{position:"relative",left:"60%"}} >
                    Back
        </Button>
                </Grid>
                <Grid item xs={4}>
                <Button variant="contained" onClick={handleNextPage} disabled={currentPage === totalPages} sx={{position:"relative",left:"20%"}}>
          Next
        </Button>
                </Grid>
            </Grid>
        </Grid>
    </Grid>
  )
}

export default Catalouge