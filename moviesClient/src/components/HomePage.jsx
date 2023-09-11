import React from 'react'
import { useState, useEffect } from 'react';

import api from '../api/axiosConfig';

function HomePage() {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
      async function fetchMovies() {
        try {
          const response = await api.get('/api/movies');
          setMovies(response.data);
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      }
  
      fetchMovies();
    }, []);

    return (
        <div>
            <h1>Top 5 Recent Movies</h1>
            <ul>
                {movies.map((movie) => (
                    <li key={movie.id}>{movie.title}</li>
                ))}
            </ul>
        </div>
    );
}

export default HomePage;