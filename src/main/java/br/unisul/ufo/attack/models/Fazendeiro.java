/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.utils.ImagePool;
import br.unisul.ufo.attack.utils.RandomUtil;

/**
 *
 * @author Win10
 */
public class Fazendeiro extends  Sprite{
    private int energia;
    public Fazendeiro(Coordenada coordenada,int energia) {
        super(ImagePool.getInstance().getImage("mira"), coordenada, 500, 500, 10,10);
        this.energia = energia;
    }

    @Override
    public void update() {
            this.energia += 5;
    }

    @Override
    public void eventoClique() {
        
    }
    
}
