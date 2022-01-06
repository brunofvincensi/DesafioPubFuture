import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from "./App";
import "./index.css";

import { Receitas } from "./components/RoutesTable/Receitas";
import { Despesas } from "./components/RoutesTable/Despesas";
import { Contas } from "./components/RoutesTable/Contas";

ReactDOM.render(
  <BrowserRouter>
		<React.StrictMode>
			<Routes>
				<Route path="/" element={<App />}>
					<Route exact path="receitas" element={< Receitas />} />
					<Route exact path="despesas" element={< Despesas />} />
					<Route exact path="contas" element={< Contas />} />
					
				</Route>
			</Routes>
		</React.StrictMode>
	</BrowserRouter>,
  document.getElementById('root')
);



