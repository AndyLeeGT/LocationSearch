import React, { createContext, useState, useContext } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Switch} from 'react-router-dom';
import LoginScreen from "./components/LoginScreen"; 

const authContext = createContext();

function useAuth() {
    return useContext(authContext);
}

function useProvideAuth() {
    const [user, setUser] = useState(null);
  
    const signin = cb => {
        console.log("sign in")
        setUser("user")
        cb()
    }

    const signout = cb => {
        console.log("sign out")
        setUser(null)
        cb()
    }
    
    return { user, signin, signout }
}

function PrivateRoute({ children, ...rest }) {
    let auth = useAuth();
    return (
      <Route
        {...rest}
        render={({ location }) =>
          auth.user ? (
            children
          ) : (
            <Redirect
              to={{
                pathname: "/login",
                state: { from: location }
              }}
            />
          )
        }
      />
    );
}

const ProvideAuth = ({ children }) => {
    const auth = useProvideAuth();
    return (
      <authContext.Provider value={auth}>
        {children}
      </authContext.Provider>
    );
}
const Map = () => { 
    return <div style={{backgroundColor: "red"}}></div>
}
const App = () => { 
    const auth = useAuth()
    return <ProvideAuth>
        <BrowserRouter>
            <Switch>
                <Route path="/login">
                    <LoginScreen auth={auth} />
                </Route>
                <PrivateRoute path="/map">
                    <Map />
                </PrivateRoute>
            </Switch>
        </BrowserRouter>
    </ProvideAuth>
}
ReactDOM.render(<App />, document.getElementById("app"))