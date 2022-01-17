import FormCard from 'componentes/FormCard';
import { useParams } from 'react-router-dom';

function Forms() {

    const params = useParams();

    return (
        <FormCard movieId={`${params.movieid}`} />
    );

}

export default Forms;