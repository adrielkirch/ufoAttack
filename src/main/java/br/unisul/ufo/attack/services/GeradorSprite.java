/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ufo.attack.services;

/**
 * Gerador de imagens 
 * @author Win10
 */
public class GeradorSprite {
    private int numNave;
    private int numVaca;

    public GeradorSprite(int numNave, int numVaca) {
        this.numNave = numNave;
        this.numVaca = numVaca;
    }

    public int getNumNave() {
        return numNave;
    }

    public void setNumNave(int numNave) {
        this.numNave = numNave;
    }

    public int getNumVaca() {
        return numVaca;
    }

    public void setNumVaca(int numVaca) {
        this.numVaca = numVaca;
    }
    
}
