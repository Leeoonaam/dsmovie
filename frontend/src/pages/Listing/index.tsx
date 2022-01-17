import axios from "axios";
import MovieCard from "componentes/MovieCard";
import Pagination from "componentes/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/request";

function Listing() {

    const [pagenumber, setPageNumber] = useState(0);

    useEffect(() => {

        axios.get(`${BASE_URL}/movies?size=12&page=0`)
            .then(response => {
                const data = response.data as MoviePage;
                setPageNumber(data.number)
            });
    }, []);




    return (

        <>
            <p>{pagenumber}</p>
            <Pagination />

            <div className="container">
                <div className="row">

                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>

                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>


                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>


                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>


                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>


                </div>

            </div>




        </>

    );

}

export default Listing;