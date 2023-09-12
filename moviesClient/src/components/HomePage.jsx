import React from 'react'
import { useState, useEffect } from 'react';

import { Link } from 'react-router-dom';

import api from '../api/axiosConfig';

import { Carousel } from "@material-tailwind/react";

import {
  Card,
  CardBody,
  CardFooter,
  Typography,
  Button,
} from "@material-tailwind/react";

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
      <div className="bg-midn ight min-h-screen">
        <Carousel
          className="scale-75 drop-shadow-xl rounded-xl"
          navigation={({ setActiveIndex, activeIndex, length }) => (
            <div className="absolute bottom-4 left-2/4 z-50 flex -translate-x-2/4 gap-2">
              {new Array(length).fill("").map((_, i) => (
                <span
                  key={i}
                  className={`block h-1 cursor-pointer rounded-2xl transition-all content-[''] ${
                    activeIndex === i ? "w-8 bg-white" : "w-4 bg-white/50"
                  }`}
                  onClick={() => setActiveIndex(i)}
                />
              ))}
            </div>
          )}
        > 
          {movies.slice(0, 5).map((movie) => (
            <div>
              <div>
                <img
                  className="absolute rounded-xl drop-shadow-xl mx-20 my-12"
                  src={movie.poster}
                />
              </div>
              <div className="absolute right-0 py-60 px-60 scale-125">
              <Card className="mt-6 w-96">
                <CardBody>
                  <Typography variant="h5" color="blue-gray" className="mb-2">
                    {movie.title}
                  </Typography>
                  <Typography>
                    Released: {movie.releaseDate} <br />
                    Trailer: {movie.trailerLink} <br />
                    Genres: {movie.genres}
                  </Typography>
                </CardBody>
                <CardFooter className="pt-0">
                  <Link to={`/movie/${movie.imdbId}`}>
                    <Button>Reviews</Button>
                  </Link>
                </CardFooter>
              </Card>
              </div>
              <img
                className=""
                src={movie.backdrops[0]}
              />
            </div>
          ))}
        </Carousel>
      </div>
    );
}

export default HomePage;