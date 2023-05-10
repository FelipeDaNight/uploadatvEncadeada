public class Encadeada {
    Encadeada Proxima; //Aponta para a próxima célula
    Encadeada Anterior; //Aponta para a célula anterior
    Object Elemento; //Objeto armazenado

    Encadeada(Encadeada prox, Object ele){
        this.Proxima = prox;
        this.Anterior = null;
        this.Elemento = ele;
        }

    Encadeada(Object ele){
        this.Proxima = null;
        this.Anterior = null;
        this.Elemento = ele;
        }

    void setProxima(Encadeada prox){
        this.Proxima = prox;
        }

    void setAnterior(Encadeada ant){
        this.Anterior = ant;
        }

    Encadeada getProxima(){
    return(this.Proxima);
        }

    Encadeada getAnterior(){
        return(this.Anterior);
        }

    Object getElemento(){
        return(this.Elemento);
        }
}