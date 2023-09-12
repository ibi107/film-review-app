import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom'; // Import useParams from react-router-dom
import api from '../api/axiosConfig';

function MovieReviewPage() {
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
      <h2>Reviews</h2>
      <ul>
        {movies.map((movie) => (
          <li>{movie.reviewIds[0].body}</li>
        ))}
      </ul>
    </div>
  );
}

export default MovieReviewPage;
