import React from 'react'
import SvgIcon from '@mui/material/SvgIcon';


const CustomIcon = (props) => {
    const { src,height,width } = props;
  return (
    <img src={src} height={height} width={width} />
  )
}

export default CustomIcon;