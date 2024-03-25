import React from 'react'
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import styled from '@emotion/styled';
import { useState } from 'react';

const OptionClothe = () => {
  const [TypeOfService,SetTypeofService]=useState(null);
  const [Demographic,SetDemographic]=useState(null);

  const CustomButton = styled(Button)(({ theme, isSelected }) => ({
    '&:hover': {
      backgroundColor: 'inherit', // Prevents color change on hover
    },
    ...(isSelected && {
      backgroundColor: 'green', // Background color when selected
     
      '&:hover': {
        backgroundColor: 'darkgreen', // Highlighted background color when selected and hovered
      },
    }),
  }));

  // const handleClick=(num)=>{
  //   SetTypeofService(num);
  // }

  return (
    <Grid container rowSpacing={1} sx={{height:"100%",width:"100%"}} direction="column">
            <Grid item direction="row" sx={{height:"70%" , width:"100%"}}>
              <Grid container sx={{padding:"2px",display:"flex",width:"100%",paddingTop:"8px"}}>
              <Grid item xs={4} sx={{display:"flex",justifyContent:"end"}}>
              <CustomButton variant="contained" style={{height:"150%",backgroundColor:"#0041C2",color:TypeOfService==1?"yellow":"white",    border: TypeOfService === 1 ? '3px solid black' : 'none',
}} onClick={()=>{SetTypeofService(1)}}>Just Wash</CustomButton>
              </Grid >
               <Grid item xs={4} sx={{display:"flex",justifyContent:"center"}}>
               <CustomButton variant="contained" style={{height:"150%",backgroundColor:"#C54B8C",color:TypeOfService==2?"yellow":"white" , border: TypeOfService === 2 ? '3px solid black' : 'none'}} onClick={()=>{SetTypeofService(2)}}>Wash & Iron</CustomButton>
               </Grid >
               <Grid item xs={4} sx={{display:"flex",justifyContent:"start"}}>
               <CustomButton variant="contained" style={{height:"150%",backgroundColor:"#008080",color:TypeOfService==3?"yellow":"white", border: TypeOfService === 3 ? '3px solid black' : 'none'}} onClick={()=>{SetTypeofService(3)}}>Dry Clean</CustomButton>
               </Grid >
              </Grid>
            </Grid>
            <Grid item sx={{ height: '30%',width:"100%",justifyContent: 'center'}}>
            <Grid container sx={{padding:"2px",display:"flex",width:"100%",paddingTop:"8px"}}>
              <Grid item xs={3} sx={{display:"flex",justifyContent:"center"}}>
              <CustomButton variant="contained" sx={{height:"100%"}} style={{backgroundColor:"grey",color:Demographic==1?"yellow":"black",    border: Demographic === 1 ? '2px solid black' : 'none'}} onClick={()=>{SetDemographic(1)}} >Kids</CustomButton>
              </Grid >
               <Grid item xs={3} sx={{display:"flex",justifyContent:"center"}}>
               <CustomButton variant="contained" sx={{height:"100%"}} style={{backgroundColor:"grey",color:Demographic==2?"yellow":"black",    border: Demographic === 2 ? '2px solid black' : 'none'}} onClick={()=>{SetDemographic(2)}}>Men</CustomButton>
               </Grid >
               <Grid item xs={3} sx={{display:"flex",justifyContent:"center"}}>
               <CustomButton variant="contained" sx={{height:"100%"}} style={{backgroundColor:"grey",color:Demographic==3?"yellow":"black",    border: Demographic === 3 ? '2px solid black' : 'none'}} onClick={()=>{SetDemographic(3)}}>Women</CustomButton>
               </Grid >
               <Grid item xs={3} sx={{display:"flex",justifyContent:"center"}}>
               <CustomButton variant="contained" sx={{height:"100%"}} style={{backgroundColor:"grey",color:Demographic==4?"yellow":"black",    border: Demographic === 4 ? '2px solid black' : 'none'}} onClick={()=>{SetDemographic(4)}}>Misc</CustomButton>
               </Grid >
               
              </Grid>
            </Grid>
        </Grid>
  )
}

export default OptionClothe