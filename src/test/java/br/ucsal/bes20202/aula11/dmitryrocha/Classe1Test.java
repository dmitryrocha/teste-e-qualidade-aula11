package br.ucsal.bes20202.aula11.dmitryrocha;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Classe1.class })


public class Classe1Test {
    @Test
    public void testarMetodo4() throws Exception {
        Classe1 objeto1 = new Classe1();
        Classe1 spy1 = PowerMockito.spy(objeto1);

        PowerMockito.mockStatic(Classe1.class);
        PowerMockito.when(Classe1.metodo1()).thenReturn(10);
        PowerMockito.when(Classe1.class, "metodo2").thenReturn(20);
        PowerMockito.when(spy1, "metodo3").thenReturn(30);

        spy1.metodo4();

        PowerMockito.verifyPrivate(Classe1.class).invoke("metodo2");
        PowerMockito.verifyPrivate(spy1).invoke("metodo3");
        PowerMockito.verifyStatic(Classe1.class);
        Classe1.metodo1();
        PowerMockito.verifyNoMoreInteractions(Classe1.class);

    }

    @Test
    public void testarMetodo5() throws Exception {
        Classe1 objeto1 = new Classe1();
        Classe1 spy1 = PowerMockito.spy(objeto1);

        PowerMockito.mockStatic(Classe1.class);
        PowerMockito.when(Classe1.metodo1()).thenReturn(10);
        PowerMockito.when(Classe1.class, "metodo2").thenReturn(20);
        PowerMockito.when(spy1, "metodo3").thenReturn(30);

        int resultadoEsperado = 60;
        int resultadoAtual = spy1.metodo5();

        Assert.assertEquals(resultadoEsperado, resultadoAtual);

        // Posso fazer o verify, mas ele não imprescindível.
    }

    @Test
    public void testarMetodo6() throws Exception {
        Classe1 objeto1 = new Classe1();
        Classe1 spy1 = PowerMockito.spy(objeto1);

        PowerMockito.mockStatic(Classe1.class);
        PowerMockito.when(Classe1.metodo1()).thenReturn(100);
        PowerMockito.when(Classe1.class, "metodo2").thenReturn(200);
        PowerMockito.when(spy1, "metodo3").thenReturn(300);

        int resultadoEsperado = 600;
        int resultadoAtual = Whitebox.invokeMethod(spy1, "metodo6");

        Assert.assertEquals(resultadoEsperado, resultadoAtual);

        // Posso fazer o verify, mas ele não imprescindível.
    }

    //Não foi feito mock, apenas foi utilizado o Whitebox para ter acesso ao método metodo7 que é privado.
    //Os parâmetros do metodo7 foram passados na chamada (valores 6 e 4).
    @Test
    public void testarMetodo7Integrado() throws Exception {
        Classe1 objeto1 = new Classe1();
        int resultadoEsperado = 10;
        int resultadoAtual = Whitebox.invokeMethod(objeto1, "metodo7", 6, 4);
        Assert.assertEquals(resultadoEsperado, resultadoAtual);
    }



}
