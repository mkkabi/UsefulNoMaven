package AbstractFactory_16;

class ComedyMovieFactory implements IMovieFactory {
    public ITollywoodMovie GetTollywoodMovie() {
        return new TollywoodComedyMovie();
    }

    public IBollywoodMovie GetBollywoodMovie() {
        return new BollywoodComedyMovie();
    }
}
