import React from 'react';
import './Button.css';
import { Link } from 'react-router-dom';

export function Button() {
  return (
    <Link to='sign-up'>
      <button className='btn'><div className='su'>Sign-Up</div></button>
    </Link>
  );
}