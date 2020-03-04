import React from 'react';
import './App.css';
import Login from './login/login';
import Register from './register/register';
import HomeForUser from './home/homeForUser';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams,
  useRouteMatch
} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    

    <Router>
    <div >
      <ul className="navbar navbar-expand-lg navbar-light bg-light">
        <li className="navbar-brand">
          <Link  className = "nav-link" to="/register">Signup</Link>
        </li>
        <li className="navbar-brand">
          <Link  className = "nav-link"  to="/login">Signin</Link>
        </li>
      </ul>


      <Switch>
        <Route exact path="/register">
          <Register/>
        </Route>
        <Route path="/login">
          <Login />
        </Route>
        <Route path="/home">
          < HomeForUser/>
        </Route>
        <Route path="/">
          < HomeForUser/>
        </Route>
      </Switch>
    </div>
  </Router>
      
  );
}

export default App;
