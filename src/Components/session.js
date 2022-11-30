import React from "react";
// sign in
const session =()=>{const SignIn = ({ handleEvent }) => {
    return <button onClick={e => handleEvent(true)}>Sign In</button>;
  };

//   log out

const Logout = ({ handleEvent }) => {
    return <button onClick={e => handleEvent(false)}>Sign out</button>;
  };

//   log in

const Login = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
  
    if (!isLoggedIn) return <SignIn handleEvent={setIsLoggedIn} />;
  
    return <Logout handleEvent={setIsLoggedIn} />;
  };

}
export default session; 