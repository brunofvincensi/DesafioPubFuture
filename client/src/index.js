import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from "./App";
import "./index.css";
import { Contas } from "./components/RoutesTable/Contas";

ReactDOM.render(
	<BrowserRouter>
		<React.StrictMode>
			<Routes>
				<Route path="/" element={<App />}>
					<Route exact path="/contas" element={<Contas />} />

				
				</Route>
			</Routes>
		</React.StrictMode>
	</BrowserRouter>,

	document.getElementById("root")
);



