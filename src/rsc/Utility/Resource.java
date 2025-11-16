package rsc.Utility;

public class Resource {

    private final String GET;
    private final String POST;
    private final String PUT;
    private final String DELETE;
    private final String Route;

    /**
     *
     * @param route Endpoint Name
     */
    public Resource(String route) {
        this.Route = route;
        this.GET = "GET";
        this.POST = "POST";
        this.PUT = "PUT";
        this.DELETE = "DELETE";
    }

    /**
     * Método que retorna el valor de la variable `GET`.
     *
     * Este método se utiliza en una API para obtener el valor asociado a la
     * variable `GET`.
     *
     * @return una cadena de texto que representa el valor actual de la variable
     * `GET`.
     */
    public String GET() {
        return this.GET;
    }

    /**
     * Método que retorna el valor de la variable `POST`.
     *
     * Este método se utiliza en una API para obtener el valor asociado a la
     * variable `POST`.
     *
     * @return una cadena de texto que representa el valor actual de la variable
     * `POST`.
     */
    public String POST() {
        return this.POST;
    }

    /**
     * Método que retorna el valor de la variable `PUT`.
     *
     * Este método se utiliza en una API para obtener el valor asociado a la
     * variable `PUT`.
     *
     * @return una cadena de texto que representa el valor actual de la variable
     * `PUT`.
     */
    public String PUT() {
        return this.PUT;
    }

    /**
     * Método que retorna el valor de la variable `DELETE`.
     *
     * Este método se utiliza en una API para obtener el valor asociado a la
     * variable `DELETE`.
     *
     * @return una cadena de texto que representa el valor actual de la variable
     * `DELETE`.
     */
    public String DELETE() {
        return this.DELETE;
    }

    /**
     * Método que retorna la ruta completa para acceder a la colección de
     * recursos.
     *
     * Este método se utiliza en una API para obtener la URL que apunta a todos
     * los recursos disponibles en la ruta especificada por la variable `Route`.
     *
     * @return una cadena de texto que representa la URL completa para acceder a
     * todos los recursos, que es la concatenación de la variable `Route` y la
     * cadena `"/all"`.
     */
    public String All() {
        return this.Route + "/all";
    }

    /**
     * Método que construye y retorna la ruta completa para encontrar un recurso
     * específico por su ID.
     *
     * Este método se utiliza en una API para obtener la URL que permite acceder
     * a un recurso específico identificado por el parámetro `id`.
     *
     * @param id el identificador único del recurso que se desea encontrar.
     * @return una cadena de texto que representa la URL completa para acceder
     * al recurso, que es la concatenación de la variable `Route`, la cadena
     * `"/find/"` y el identificador `id`.
     */
    public String Find(String id) {
        return this.Route + "/find/" + id;
    }

    public String Find(int id) {
        return this.Route + "/find/" + id;
    }

    /**
     * Método que construye y retorna la ruta completa para crear un nuevo
     * recurso.
     *
     * Este método se utiliza en una API para obtener la URL que permite crear
     * un nuevo recurso.
     *
     * @return una cadena de texto que representa la URL completa para crear un
     * nuevo recurso, que es la concatenación de la variable `Route` y la cadena
     * `"/create"`.
     */
    public String Create() {
        return this.Route + "/create";
    }

    /**
     * Método que construye y retorna la ruta completa para actualizar un
     * recurso específico por su ID.
     *
     * Este método se utiliza en una API para obtener la URL que permite
     * actualizar un recurso identificado por el parámetro `id`.
     *
     * @param id el identificador único del recurso que se desea actualizar.
     * @return una cadena de texto que representa la URL completa para
     * actualizar el recurso, que es la concatenación de la variable `Route`, la
     * cadena `"/find/"` y el identificador `id`.
     */
    public String Update(String id) {
        return this.Route + "/update/" + id;
    }

    public String Update(int id) {
        return this.Route + "/update/" + id;
    }

    /**
     * Método que construye y retorna la ruta completa para eliminar un recurso
     * específico por su ID.
     *
     * Este método se utiliza en una API para obtener la URL que permite
     * eliminar un recurso identificado por el parámetro `id`.
     *
     * @param id el identificador único del recurso que se desea eliminar.
     * @return una cadena de texto que representa la URL completa para eliminar
     * el recurso, que es la concatenación de la variable `Route`, la cadena
     * `"/delete/"` y el identificador `id`.
     */
    public String Delete(String id) {
        return this.Route + "/delete/" + id;
    }

    public String Delete(int id) {
        return this.Route + "/delete/" + id;
    }

    /**
     * Método que construye y retorna una ruta completa combinando la ruta base
     * con una ruta adicional.
     *
     * Este método se utiliza en una API para generar una URL completa
     * combinando la ruta base especificada por la variable `Route` con una ruta
     * adicional proporcionada como parámetro `route2`.
     *
     * @param route2 la ruta adicional que se desea agregar a la ruta base.
     * @return una cadena de texto que representa la URL completa combinada, que
     * es la concatenación de la variable `Route`, una barra (`"/"`), y la ruta
     * adicional `route2`.
     */
    public String Make(String route2) {
        return this.Route + "/" + route2;
    }

}
