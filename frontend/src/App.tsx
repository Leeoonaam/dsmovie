import { // importando 3 componentes para configurar as rotas
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from 'pages/Listing';
import Forms from 'pages/Forms';
import NavBar from "./componentes/navbar";

function App() {
  return (
    //inicia as configurações da rota - por padrão todas as paginas tera o navbar - routes configura rota por rota - Route seleciona a pagina que devera abrir
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/Forms">
          <Route path=":movieId" element={<Forms />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;