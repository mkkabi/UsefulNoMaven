/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns_Vaaskaran.Observer_MultipleObserversAndSubj;

/**
 *
 * @author qwe
 */
public class Observer1 implements IObserver {
	@Override
	public void update(String s, int i) {
		System.out.println("Observer1: myValue in " + s + " is now: " + i);
	}
}
