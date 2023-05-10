public class ListaDupla {
    Encadeada Primeira;
    Encadeada Ultima;
    int TotaldeElementos = 0;

    boolean PosicaoOcupada(int pos){
        return((pos >= 0)&&(pos < this.TotaldeElementos));
        }
    
        Encadeada PegaCelula(int pos){
        if(!this.PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao nao existe");    
        }else{
            Encadeada atual = this.Primeira;
            for(int i=0; i < pos; i++){
            atual = atual.getProxima();
            }
            return(atual);
            } 
        }

    Object Pega(int pos){
        return(this.PegaCelula(pos).getElemento());
        }        

    void AdicionaNoComeco(Object elemento){
        if(this.TotaldeElementos == 0){
            Encadeada nova = new Encadeada(elemento);
            this.Primeira = nova;
            this.Ultima = nova;
        }else{
            Encadeada nova = new Encadeada(this.Primeira, elemento);
            this.Primeira.setAnterior(nova);
            this.Primeira = nova;
        }
        this.TotaldeElementos++; }

    void Adiciona(Object elemento){
        if(this.TotaldeElementos == 0){
            this.AdicionaNoComeco(elemento);
        }else{
            Encadeada nova = new Encadeada(elemento);
            this.Ultima.setProxima(nova);
            nova.setAnterior(this.Ultima);
            this.Ultima = nova;
            this.TotaldeElementos++;
            } 
        }

    void Adiciona(int pos, Object elemento){
        if(pos == 0){
            this.AdicionaNoComeco(elemento);
        }else if(pos == this.TotaldeElementos){
            this.Adiciona(elemento);
        }else {
            Encadeada anterior = this.PegaCelula(pos-1);
            Encadeada proxima = anterior.getProxima();
            Encadeada nova = new Encadeada(anterior.getProxima(),elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.TotaldeElementos++;
            } 
        }

    void RemovedoComeco(){
        if(!this.PosicaoOcupada(0)){
            throw new IllegalArgumentException("Posicao nao Existe");
        }else{
            this.Primeira = this.Primeira.getProxima();
            this.TotaldeElementos--;
            }
        if(this.TotaldeElementos == 0){
            this.Ultima = null;
            } 
        }

    void RemovedoFim(){
        if(!this.PosicaoOcupada(TotaldeElementos-1)){
            throw new IllegalArgumentException("Posicao nao existe");
        }else{
            if(this.TotaldeElementos == 1){
            this.RemovedoComeco();
        }else{
            Encadeada penultima = this.Ultima.getAnterior();
                penultima.setProxima(null);
                this.Ultima = penultima;
                this.TotaldeElementos--;
            } 
        } 
    }

    void Remove(int pos){
        if(!this.PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao nao Existe");
        }else{
            if (pos == 0){
                this.RemovedoComeco();
            }else if(pos == this.TotaldeElementos -1){
                this.RemovedoFim();
            }else {
                Encadeada anterior = this.PegaCelula(pos -1);
                Encadeada atual = anterior.getProxima();
                Encadeada proxima = atual.getProxima();
                anterior.setProxima(proxima);
                proxima.setAnterior(anterior);
                this.TotaldeElementos--;
                } 
            }
        }

    boolean Contem(Object elemento){
        Encadeada atual = this.Primeira;
        while(atual != null){
            if(atual.getElemento().equals(elemento)){
            return(true);
            }
        atual = atual.getProxima();
        }
        return(false);
        }

    int tamanho(){
        return(this.TotaldeElementos);
        }

    void EsvaziaLista(){
        this.Primeira = null;
        this.Ultima = null;
        this.TotaldeElementos = 0;
        }

    String Imprimir(){
        if(this.TotaldeElementos == 0){
            return("[]");
        }else{
            StringBuilder builder = new StringBuilder("[");
            Encadeada atual = this.Primeira;
        for(int i=0; i < this.TotaldeElementos -1; i++){
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
            }
            builder.append(atual.getElemento());
            builder.append("]");
            return(builder.toString());
            } 
        }


}