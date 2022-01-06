import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link, Outlet } from "react-router-dom";
import { Body } from "./components/Body";
import { Header } from "./components/Header";


function App() {
    return (
        <Body>
            <Header />
            <div id="content">
         
                <Outlet id="outlet" />
            </div>
        </Body>
    );
}

export default App;