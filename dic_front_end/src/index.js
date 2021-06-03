import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter, Switch, Route } from "react-router-dom";
import routes from "./routers";

import './index.css';

ReactDOM.render(
  <HashRouter>
    <Switch>
      {
        routes.map((route, i) => {
          return <Route
            path={route.path} 
            key={i} 
            render={(props) => (
              <route.component {...props} routes={route.routes} />
            )} />
        })
      }
    </Switch>
  </HashRouter>,
  document.getElementById('root')
);