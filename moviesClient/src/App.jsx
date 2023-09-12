import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import HomePage from './components/HomePage';
import MovieReviewPage from './components/MovieReviewPage';

function App() {

  return (
    <Router>
    <div>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/movie/:imdbId" element={<MovieReviewPage />}/>
      </Routes>
    </div>
    </Router>
  );
}

export default App;
