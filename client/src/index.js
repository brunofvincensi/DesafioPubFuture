import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from "./App";
import "./index.css";
import { Contas } from "./components/RoutesTable/Contas";
import { Receitas } from "./components/RoutesTable/Receitas";
import { Despesas } from "./components/RoutesTable/Despesas";
import ContUp from "./components/Updates/ContaUp";
import DespesaUp from "./components/Updates/DespesaUp";
import ReceitaUp from "./components/Updates/ReceitaUp";
import ContaInsert from "./components/Updates/ContaInsert";
import DespesaInsert from "./components/Updates/DespesaInsert";
import ReceitaInsert from "./components/Updates/ReceitaInsert";

ReactDOM.render(
	<BrowserRouter>
		<React.StrictMode>
			<Routes>
				<Route path="/" element={<App />}>
					<Route exact path="/" element={<Contas />} />

					<Route path="conta/:id" element={<ContUp />}></Route>
					<Route path="receitas" element={<Receitas />}></Route>
					<Route path="despesas" element={<Despesas />}></Route>
					<Route path="despesaUp/:id" element={<DespesaUp />}></Route>
					<Route path="receitaUp/:id" element={<ReceitaUp />}></Route>
					<Route path="add-conta" element={<ContaInsert />}></Route>
					<Route path="conta/:id/add-despesa" element={<DespesaInsert />}></Route>
					<Route path="conta/:id/add-receita" element={<ReceitaInsert />}></Route>
				</Route>
			</Routes>
		</React.StrictMode>
	</BrowserRouter>,

	document.getElementById("root")
);



