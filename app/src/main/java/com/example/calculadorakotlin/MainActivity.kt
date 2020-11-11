package com.example.calculadorakotlin

import android.graphics.Color
import android.os.Bundle
import android.view.Surface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var resultado = 0.0
    var proceso1 = ""
    var proceso2 = ""
    var resultadoH = 0
    var resultadoHHex = ""

    fun cuentasHorizontal(Signo: String) {
        var resultadoDeCuenta = 0
        var resultadoDeCuentaHex =""
        var num1 = 0
        var num2 = 0
        if (Signo.equals("+")) {
            if (!buttonDecimal.isEnabled) {
                resultadoDeCuenta = proceso1.toInt() + proceso2.toInt()
            } else {
                if (!buttonBinario.isEnabled) {
                    num1 = convertirDeBinario_Decimal(proceso1.toInt())
                    num2 = convertirDeBinario_Decimal(proceso2.toInt())
                    resultadoDeCuenta = num1 + num2
                    resultadoDeCuenta = Integer.toBinaryString(resultadoDeCuenta).toInt()
                } else {
                    num1 = convertirDeHexadecimal_Decimal(proceso1)
                    num2 = convertirDeHexadecimal_Decimal(proceso2)
                    resultadoDeCuenta = num1 + num2
                    resultadoDeCuentaHex = Integer.toHexString(resultadoDeCuenta)
                }
            }
        } else {
            if (Signo.equals("-")) {
                if (!buttonDecimal.isEnabled) {
                    resultadoDeCuenta = proceso1.toInt() - proceso2.toInt()
                } else {
                    if (!buttonBinario.isEnabled) {
                        num1 = convertirDeBinario_Decimal(proceso1.toInt())
                        num2 = convertirDeBinario_Decimal(proceso2.toInt())
                        resultadoDeCuenta = num1 - num2
                        resultadoDeCuenta = Integer.toBinaryString(resultadoDeCuenta).toInt()
                    } else {
                        num1 = convertirDeHexadecimal_Decimal(proceso1)
                        num2 = convertirDeHexadecimal_Decimal(proceso2)
                        resultadoDeCuenta = num1 - num2
                        resultadoDeCuentaHex = Integer.toHexString(resultadoDeCuenta)
                    }
                }
            } else {
                if (Signo.equals("x")) {
                    if (!buttonDecimal.isEnabled) {
                        resultadoDeCuenta = proceso1.toInt() * proceso2.toInt()
                    } else {
                        if (!buttonBinario.isEnabled) {
                            num1 = convertirDeBinario_Decimal(proceso1.toInt())
                            num2 = convertirDeBinario_Decimal(proceso2.toInt())
                            resultadoDeCuenta = num1 * num2
                            resultadoDeCuenta = Integer.toBinaryString(resultadoDeCuenta).toInt()
                        } else {
                            num1 = convertirDeHexadecimal_Decimal(proceso1)
                            num2 = convertirDeHexadecimal_Decimal(proceso2)
                            resultadoDeCuenta = num1 * num2
                            resultadoDeCuentaHex = Integer.toHexString(resultadoDeCuenta)
                        }
                    }
                } else {
                    if (!buttonDecimal.isEnabled) {
                        error()
                    } else {
                        if (!buttonBinario.isEnabled) {
                            if (proceso2.toInt() == 0) {
                                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                            } else {
                                num1 = convertirDeBinario_Decimal(proceso1.toInt())
                                num2 = convertirDeBinario_Decimal(proceso2.toInt())
                                resultadoDeCuenta = num1 / num2
                                resultadoDeCuenta = Integer.toBinaryString(resultadoDeCuenta).toInt()
                            }
                        } else {
                            if (proceso2.toInt() == 0) {
                                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                            } else {
                                num1 = convertirDeHexadecimal_Decimal(proceso1)
                                num2 = convertirDeHexadecimal_Decimal(proceso2)
                                resultadoDeCuenta = num1 / num2
                                resultadoDeCuentaHex = Integer.toHexString(resultadoDeCuenta)
                            }
                        }
                    }
                }
            }
        }
        if (!buttonHexadecimal.isEnabled) {
            textViewResultado.text = resultadoDeCuentaHex
            resultadoHHex = textViewResultado.text.toString()
            textViewNum1.text = resultadoHHex
            proceso1 = resultadoHHex
        } else {
            textViewResultado.text = resultadoDeCuenta.toString()
            resultadoH = textViewResultado.text.toString().toInt()
            textViewNum1.text = resultadoH.toString()
            proceso1 = resultadoH.toString()
        }

    }

    fun caracterHexadecimal_Decimal(caracter: Char): Int {
        return when (caracter) {
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            else -> caracter.toString().toInt()
        }
    }

    fun convertirDeHexadecimal_Decimal(hexadecimal: String): Int {
        var decimal: Int = 0
        var potencia = 0
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor = caracterHexadecimal_Decimal(hexadecimal[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toInt() * valor
            decimal += elevado
            potencia++
        }
        return decimal
    }

    fun convertirDeBinario_Decimal(num: Int): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Int

        while (num != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun signo0() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("0")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("0")
            textViewNum2.text = proceso2
        }
    }

    fun signo1() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("1")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("1")
            textViewNum2.text = proceso2
        }
    }

    fun signo2() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("2")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("2")
            textViewNum2.text = proceso2
        }
    }

    fun signo3() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("3")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("3")
            textViewNum2.text = proceso2
        }
    }

    fun signo4() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("4")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("4")
            textViewNum2.text = proceso2
        }
    }

    fun signo5() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("5")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("5")
            textViewNum2.text = proceso2
        }
    }

    fun signo6() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("6")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("6")
            textViewNum2.text = proceso2
        }
    }

    fun signo7() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("7")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("7")
            textViewNum2.text = proceso2
        }
    }

    fun signo8() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("8")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("8")
            textViewNum2.text = proceso2
        }
    }

    fun signo9() {
        if (textViewSigno.text.equals("Signo")) {
            proceso1 = proceso1.plus("9")
            textViewNum1.text = proceso1
        } else {
            proceso2 = proceso2.plus("9")
            textViewNum2.text = proceso2
        }
    }

    fun signoDiv() {
        if (textViewNum1.text.equals("-")) {
            Toast.makeText(this, "No hay numeros para utilizar signos", Toast.LENGTH_SHORT).show()
        } else {
            if (textViewNum1.text.equals("Numero 1")) {
                Toast.makeText(this, "No se introdujo un primer numero", Toast.LENGTH_SHORT).show()
            } else {
                textViewSigno.text = "/"
                bloquearSignos()
            }
        }
    }

    fun signoMult() {
        if (textViewNum1.text.equals("-")) {
            Toast.makeText(this, "No hay numeros para utilizar signos", Toast.LENGTH_SHORT).show()
        } else {
            if (textViewNum1.text.equals("Numero 1")) {
                Toast.makeText(this, "No se introdujo un primer numero", Toast.LENGTH_SHORT).show()
            } else {
                textViewSigno.text = "x"
                bloquearSignos()
            }
        }
    }

    fun signoSuma() {
        if (textViewNum1.text.equals("-")) {
            Toast.makeText(this, "No hay numeros para utilizar signos", Toast.LENGTH_SHORT).show()
        } else {
            if (textViewNum1.text.equals("Numero 1")) {
                Toast.makeText(this, "No se introdujo un primer numero", Toast.LENGTH_SHORT).show()
            } else {
                textViewSigno.text = "+"
                bloquearSignos()
            }
        }
    }

    fun signoResta() {
        if (textViewNum1.text.equals("-")) {
            Toast.makeText(this, "No hay numeros para utilizar signos", Toast.LENGTH_SHORT).show()
        } else {
            if (textViewNum1.text.equals("Numero 1")) {
                proceso1 = proceso1.plus("-")
                textViewNum1.text = proceso1
            } else {
                if (textViewNum1.text.equals("-")) {
                    Toast.makeText(
                        this,
                        "Introduce un numero si quiere continuar",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (textViewSigno.text.equals("Signo")) {
                        textViewSigno.text = "-"
                        bloquearSignos()
                        buttonPunto.setEnabled(true)
                        buttonPunto.setBackgroundColor(Color.parseColor("#FFEB3B"))
                    } else {
                        if (textViewNum2.text.equals("Numero 2")) {
                            proceso2 = proceso2.plus("-")
                            textViewNum2.text = proceso2
                            buttonResta.setEnabled(false);
                            buttonResta.setBackgroundColor(Color.WHITE)
                        } else {
                            Toast.makeText(
                                this,
                                "Ya no puedes introducir negativos, se desactiva el boton resta",
                                Toast.LENGTH_LONG
                            ).show()
                            buttonResta.setEnabled(false);
                            buttonResta.setBackgroundColor(Color.WHITE)
                        }
                    }
                }
            }
        }
    }

    //Con los botones poder el modo de la calculadora: Binario, Decimal y Hexadecimal
    fun modoCalculadora(num: Int) {
        //A binario
        if (num == 0) {
            //Desde Decimales
            buttonDos.setEnabled(false)
            buttonDos.setBackgroundColor(Color.WHITE)
            buttonTres.setEnabled(false)
            buttonTres.setBackgroundColor(Color.WHITE)
            buttonCuatro.setEnabled(false)
            buttonCuatro.setBackgroundColor(Color.WHITE)
            buttonCinco.setEnabled(false)
            buttonCinco.setBackgroundColor(Color.WHITE)
            buttonSeis.setEnabled(false)
            buttonSeis.setBackgroundColor(Color.WHITE)
            buttonSiete.setEnabled(false)
            buttonSiete.setBackgroundColor(Color.WHITE)
            buttonOcho.setEnabled(false)
            buttonOcho.setBackgroundColor(Color.WHITE)
            buttonNueve.setEnabled(false)
            buttonNueve.setBackgroundColor(Color.WHITE)
            //Desde Hexadecimal
            if (!buttonHexadecimal.isEnabled) {
                buttonA.setEnabled(false)
                buttonA.setBackgroundColor(Color.WHITE)
                buttonB.setEnabled(false)
                buttonB.setBackgroundColor(Color.WHITE)
                buttonC.setEnabled(false)
                buttonC.setBackgroundColor(Color.WHITE)
                buttonD.setEnabled(false)
                buttonD.setBackgroundColor(Color.WHITE)
                buttonE.setEnabled(false)
                buttonE.setBackgroundColor(Color.WHITE)
                buttonF.setEnabled(false)
                buttonF.setBackgroundColor(Color.WHITE)
            }
        } else {
            //A Decimal
            if (num == 1) {
                //Desde Binario
                if (!buttonBinario.isEnabled) {
                    buttonDos.setEnabled(true)
                    buttonDos.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonTres.setEnabled(true)
                    buttonTres.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonCuatro.setEnabled(true)
                    buttonCuatro.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonCinco.setEnabled(true)
                    buttonCinco.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonSeis.setEnabled(true)
                    buttonSeis.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonSiete.setEnabled(true)
                    buttonSiete.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonOcho.setEnabled(true)
                    buttonOcho.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonNueve.setEnabled(true)
                    buttonNueve.setBackgroundColor(Color.parseColor("#FF5722"))
                    //Desde Hexadecimal
                } else {
                    buttonA.setEnabled(false)
                    buttonA.setBackgroundColor(Color.WHITE)
                    buttonB.setEnabled(false)
                    buttonB.setBackgroundColor(Color.WHITE)
                    buttonC.setEnabled(false)
                    buttonC.setBackgroundColor(Color.WHITE)
                    buttonD.setEnabled(false)
                    buttonD.setBackgroundColor(Color.WHITE)
                    buttonE.setEnabled(false)
                    buttonE.setBackgroundColor(Color.WHITE)
                    buttonF.setEnabled(false)
                    buttonF.setBackgroundColor(Color.WHITE)
                }
                //A Hexadecimal
            } else {
                //Desde Decimal
                buttonA.setEnabled(true)
                buttonA.setBackgroundColor(Color.parseColor("#4CAF50"))
                buttonB.setEnabled(true)
                buttonB.setBackgroundColor(Color.parseColor("#4CAF50"))
                buttonC.setEnabled(true)
                buttonC.setBackgroundColor(Color.parseColor("#4CAF50"))
                buttonD.setEnabled(true)
                buttonD.setBackgroundColor(Color.parseColor("#4CAF50"))
                buttonE.setEnabled(true)
                buttonE.setBackgroundColor(Color.parseColor("#4CAF50"))
                buttonF.setEnabled(true)
                buttonF.setBackgroundColor(Color.parseColor("#4CAF50"))
                //Desde Binario
                if (!buttonBinario.isEnabled) {
                    buttonDos.setEnabled(true)
                    buttonDos.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonTres.setEnabled(true)
                    buttonTres.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonCuatro.setEnabled(true)
                    buttonCuatro.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonCinco.setEnabled(true)
                    buttonCinco.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonSeis.setEnabled(true)
                    buttonSeis.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonSiete.setEnabled(true)
                    buttonSiete.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonOcho.setEnabled(true)
                    buttonOcho.setBackgroundColor(Color.parseColor("#FF5722"))
                    buttonNueve.setEnabled(true)
                    buttonNueve.setBackgroundColor(Color.parseColor("#FF5722"))
                }
            }
        }
    }

    //Bloque para que no se puedan pulsar los botones Suma, Multiplicacion y Division (Resta no esta ya que tiene uno propio para usar el negativo
    fun bloquearSignos() {
        buttonSuma.setEnabled(false);
        buttonSuma.setBackgroundColor(Color.WHITE)
        buttonMult.setEnabled(false);
        buttonMult.setBackgroundColor(Color.WHITE)
        buttonDiv.setEnabled(false);
        buttonDiv.setBackgroundColor(Color.WHITE)
    }

    //Desbloquea todos los signos y el punto para poder utilizar su uso
    fun desbloquearSignos() {
        buttonSuma.setEnabled(true);
        buttonSuma.setBackgroundColor(Color.BLACK)
        buttonResta.setEnabled(true);
        buttonResta.setBackgroundColor(Color.BLACK)
        buttonMult.setEnabled(true);
        buttonMult.setBackgroundColor(Color.BLACK)
        buttonDiv.setEnabled(true);
        buttonDiv.setBackgroundColor(Color.BLACK)
    }

    fun introducirPunto() {
        if (textViewSigno.text.equals("Signo")) {
            if (textViewNum1.text.equals("Numero 1") or textViewNum1.text.equals("-")) {
                Toast.makeText(
                    this,
                    "Primero introduce un numero para poder usarlo",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                proceso1 = proceso1.plus(".")
                textViewNum1.text = proceso1
                buttonPunto.setEnabled(false)
                buttonPunto.setBackgroundColor(Color.WHITE)
            }
        } else {
            if (textViewNum2.text.equals("Numero 2") or textViewNum2.text.equals("-")) {
                Toast.makeText(
                    this,
                    "Primero introduce un numero para poder usarlo",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                proceso2 = proceso2.plus(".")
                textViewNum2.text = proceso2
                buttonPunto.setEnabled(false)
                buttonPunto.setBackgroundColor(Color.WHITE)
            }
        }
    }
    
    fun error() {
        if (proceso2.toDouble() == 0.0) {
            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
        } else {
            resultado = proceso1.toDouble() / proceso2.toDouble()
        }
    }
                                                            //VERTICAL
//--------------------------------------------------------------------------------------------------------------------------------------\\

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rotacion = windowManager.defaultDisplay.rotation
        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {

            buttonCero.setOnClickListener {
                signo0()
            }

            buttonUno.setOnClickListener {
                signo1()
            }

            buttonDos.setOnClickListener {
                signo2()
            }

            buttonTres.setOnClickListener {
                signo3()
            }

            buttonCuatro.setOnClickListener {
                signo4()
            }

            buttonCinco.setOnClickListener {
                signo5()
            }

            buttonSeis.setOnClickListener {
                signo6()
            }

            buttonSiete.setOnClickListener {
                signo7()
            }

            buttonOcho.setOnClickListener {
                signo8()
            }

            buttonNueve.setOnClickListener {
                signo9()
            }

            buttonPunto.setOnClickListener {
                introducirPunto()
            }

            buttonSuma.setOnClickListener {
                signoSuma()
                buttonPunto.setEnabled(true)
                buttonPunto.setBackgroundColor(Color.parseColor("#FFEB3B"))
            }

            buttonResta.setOnClickListener {
                signoResta()
            }

            buttonMult.setOnClickListener {
                signoMult()
                buttonPunto.setEnabled(true)
                buttonPunto.setBackgroundColor(Color.parseColor("#FFEB3B"))
            }

            buttonDiv.setOnClickListener {
                signoDiv()
                buttonPunto.setEnabled(true)
                buttonPunto.setBackgroundColor(Color.parseColor("#FFEB3B"))
            }

            buttonReinicio.setOnClickListener {
                proceso1 = ""
                proceso2 = ""
                textViewNum1.text = "Numero 1"
                textViewSigno.text = "Signo"
                textViewNum2.text = "Numero 2"
                textViewResultado.text = "Resultado"
                desbloquearSignos()
                buttonPunto.setEnabled(true);
                buttonPunto.setBackgroundColor(Color.parseColor("#FFEB3B"))
            }

            buttonIgual.setOnClickListener {
                if (textViewNum1.text.equals("Numero 1") or textViewSigno.text.equals("Signo") or textViewNum2.text.equals(
                        "Numero 2"
                    ) ) {
                    Toast.makeText(
                        this,
                        "No puede pulsar resultado sin haber datos en cada hueco",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (textViewNum2.text.equals("-")) {
                        Toast.makeText(
                            this,
                            "Falta un numero en el segundo hueco",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        when(textViewSigno.text){
                            "+" -> resultado = proceso1.toDouble() + proceso2.toDouble()
                            "-" -> resultado = proceso1.toDouble() - proceso2.toDouble()
                            "x" -> resultado = proceso1.toDouble() * proceso2.toDouble()
                            "/" -> error()
                        }
                        textViewResultado.text = resultado.toString()
                        proceso1 = resultado.toString()
                        proceso2 = ""
                        textViewNum1.text = resultado.toString()
                        textViewSigno.text = "Signo"
                        textViewNum2.text = "Numero 2"
                        desbloquearSignos()
                        buttonPunto.setEnabled(false)
                        buttonPunto.setBackgroundColor(Color.WHITE)
                    }
                }
            }
                                                                    //HORIZONTAL
//------------------------------------------------------------------------------------------------------------------------------------------------------------\\
        } else {

            buttonHexadecimal.setOnClickListener {
                modoCalculadora(2)
                if (!buttonDecimal.isEnabled) {
                    if (!textViewNum1.text.equals("Numero 1")) {
                        textViewNum1.text = (Integer.toHexString(textViewNum1.text.toString().toInt()))
                        proceso1 = textViewNum1.text.toString()
                    }
                    if (!textViewNum2.text.equals("Numero 2")) {
                        textViewNum2.text = (Integer.toHexString(textViewNum2.text.toString().toInt()))
                        proceso2 = textViewNum2.text.toString()
                    }
                    if (!textViewResultado.text.equals("Resultado")) {
                        textViewResultado.text = (Integer.toHexString(textViewResultado.text.toString().toInt()))
                        resultadoHHex = textViewResultado.text.toString()
                    }
                } else {
                    if (!textViewNum1.text.equals("Numero 1")) {
                        textViewNum1.text = Integer.toHexString(convertirDeBinario_Decimal(textViewNum1.text.toString().toInt()))
                        proceso1 = textViewNum1.text.toString()
                    }
                    if (!textViewNum2.text.equals("Numero 2")) {
                        textViewNum2.text = Integer.toHexString(convertirDeBinario_Decimal(textViewNum2.text.toString().toInt()))
                        proceso2 = textViewNum2.text.toString()
                    }
                    if (!textViewResultado.text.equals("Resultado")) {
                        textViewResultado.text = Integer.toHexString(convertirDeBinario_Decimal(textViewResultado.text.toString().toInt()))
                        resultadoHHex = textViewResultado.text.toString()
                    }
                }

                buttonHexadecimal.setEnabled(false)
                buttonHexadecimal.setBackgroundColor(Color.parseColor("#79C3FD"))
                buttonDecimal.setEnabled(true)
                buttonDecimal.setBackgroundColor(Color.parseColor("#2196F3"))
                buttonBinario.setEnabled(true)
                buttonBinario.setBackgroundColor(Color.parseColor("#2196F3"))
            }

            buttonDecimal.setOnClickListener {
                modoCalculadora(1)
                if (!buttonBinario.isEnabled) {
                    if (!textViewNum1.text.equals("Numero 1")) {
                        textViewNum1.text = (convertirDeBinario_Decimal(
                            Integer.parseInt(
                                textViewNum1.text.toString()
                            )
                        ).toString())
                        proceso1 = textViewNum1.text.toString()
                    }
                    if (!textViewNum2.text.equals("Numero 2")) {
                        textViewNum2.text = (convertirDeBinario_Decimal(
                            Integer.parseInt(
                                textViewNum2.text.toString()
                            )
                        ).toString())
                        proceso2 = textViewNum2.text.toString()
                    }
                    if (!textViewResultado.text.equals("Resultado")) {
                        textViewResultado.text = (convertirDeBinario_Decimal(
                            Integer.parseInt(
                                textViewResultado.text.toString()
                            )
                        ).toString())
                        resultadoH = textViewResultado.text.toString().toInt()
                    }
                } else {
                    if (!textViewNum1.text.equals("Numero 1")) {
                        textViewNum1.text = convertirDeHexadecimal_Decimal(textViewNum1.text.toString()).toString()
                        proceso1 = textViewNum1.text.toString()
                    }
                    if (!textViewNum2.text.equals("Numero 2")) {
                        textViewNum2.text = convertirDeHexadecimal_Decimal(textViewNum2.text.toString()).toString()
                        proceso2 = textViewNum2.text.toString()
                    }
                    if (!textViewResultado.text.equals("Resultado")) {
                        textViewResultado.text = convertirDeHexadecimal_Decimal(textViewResultado.text.toString()).toString()
                        resultadoH = textViewResultado.text.toString().toInt()
                    }
                }
                buttonDecimal.setEnabled(false)
                buttonDecimal.setBackgroundColor(Color.parseColor("#79C3FD"))
                buttonBinario.setEnabled(true)
                buttonBinario.setBackgroundColor(Color.parseColor("#2196F3"))
                buttonHexadecimal.setEnabled(true)
                buttonHexadecimal.setBackgroundColor(Color.parseColor("#2196F3"))
            }

            buttonBinario.setOnClickListener {
                modoCalculadora(0)
                if (!buttonDecimal.isEnabled) {
                    if (!textViewNum1.text.equals("Numero 1")) {
                        textViewNum1.text = (Integer.toBinaryString(
                            textViewNum1.text.toString().toInt()
                        ))
                        proceso1 = textViewNum1.text.toString()
                    }
                    if (!textViewNum2.text.equals("Numero 2")) {
                        textViewNum2.text = (Integer.toBinaryString(
                            textViewNum2.text.toString().toInt()
                        ))
                        proceso2 = textViewNum2.text.toString()
                    }
                    if (!textViewResultado.text.equals("Resultado")) {
                        textViewResultado.text = (Integer.toBinaryString(
                            textViewResultado.text.toString().toInt()
                        ))
                        resultadoH = textViewResultado.text.toString().toInt()
                    }
                } else {
                    if (!textViewNum1.text.equals("Numero 1")) {
                        textViewNum1.text = Integer.toBinaryString(convertirDeHexadecimal_Decimal(textViewNum1.text.toString()))
                        proceso1 = textViewNum1.text.toString()
                    }
                    if (!textViewNum2.text.equals("Numero 2")) {
                        textViewNum2.text = Integer.toBinaryString(convertirDeHexadecimal_Decimal(textViewNum2.text.toString()))
                        proceso2 = textViewNum2.text.toString()
                    }
                    if (!textViewResultado.text.equals("Resultado")) {
                        textViewResultado.text = Integer.toBinaryString(convertirDeHexadecimal_Decimal(textViewResultado.text.toString()))
                        resultadoH = textViewResultado.text.toString().toInt()
                    }
                }
                buttonBinario.setEnabled(false)
                buttonBinario.setBackgroundColor(Color.parseColor("#79C3FD"))
                buttonDecimal.setEnabled(true)
                buttonDecimal.setBackgroundColor(Color.parseColor("#2196F3"))
                buttonHexadecimal.setEnabled(true)
                buttonHexadecimal.setBackgroundColor(Color.parseColor("#2196F3"))
            }

            buttonCero.setOnClickListener {
                signo0()
            }

            buttonUno.setOnClickListener {
                signo1()
            }

            buttonDos.setOnClickListener {
                signo2()
            }

            buttonTres.setOnClickListener {
                signo3()
            }

            buttonCuatro.setOnClickListener {
                signo4()
            }

            buttonCinco.setOnClickListener {
                signo5()
            }

            buttonSeis.setOnClickListener {
                signo6()
            }

            buttonSiete.setOnClickListener {
                signo7()
            }

            buttonOcho.setOnClickListener {
                signo8()
            }

            buttonNueve.setOnClickListener {
                signo9()
            }

            buttonA.setOnClickListener {
                if (textViewSigno.text.equals("Signo")) {
                    proceso1 = proceso1.plus("a")
                    textViewNum1.text = proceso1
                } else {
                    proceso2 = proceso2.plus("a")
                    textViewNum2.text = proceso2
                }
            }
            buttonB.setOnClickListener {
                if (textViewSigno.text.equals("Signo")) {
                    proceso1 = proceso1.plus("b")
                    textViewNum1.text = proceso1
                } else {
                    proceso2 = proceso2.plus("b")
                    textViewNum2.text = proceso2
                }
            }
            buttonC.setOnClickListener {
                if (textViewSigno.text.equals("Signo")) {
                    proceso1 = proceso1.plus("c")
                    textViewNum1.text = proceso1
                } else {
                    proceso2 = proceso2.plus("c")
                    textViewNum2.text = proceso2
                }
            }
            buttonD.setOnClickListener {
                if (textViewSigno.text.equals("Signo")) {
                    proceso1 = proceso1.plus("d")
                    textViewNum1.text = proceso1
                } else {
                    proceso2 = proceso2.plus("d")
                    textViewNum2.text = proceso2
                }
            }
            buttonE.setOnClickListener {
                if (textViewSigno.text.equals("Signo")) {
                    proceso1 = proceso1.plus("e")
                    textViewNum1.text = proceso1
                } else {
                    proceso2 = proceso2.plus("e")
                    textViewNum2.text = proceso2
                }
            }
            buttonF.setOnClickListener {
                if (textViewSigno.text.equals("Signo")) {
                    proceso1 = proceso1.plus("f")
                    textViewNum1.text = proceso1
                } else {
                    proceso2 = proceso2.plus("f")
                    textViewNum2.text = proceso2
                }
            }

            buttonSuma.setOnClickListener {
                signoSuma()
            }

            buttonResta.setOnClickListener {
                if (textViewNum1.text.equals("-")) {
                    Toast.makeText(this, "No hay numeros para utilizar signos", Toast.LENGTH_SHORT).show()
                } else {
                    if (textViewNum1.text.equals("Numero 1")) {
                        proceso1 = proceso1.plus("-")
                        textViewNum1.text = proceso1
                    } else {
                        if (textViewNum1.text.equals("-")) {
                            Toast.makeText(
                                this,
                                "Introduce un numero si quiere continuar",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            if (textViewSigno.text.equals("Signo")) {
                                textViewSigno.text = "-"
                                bloquearSignos()
                            } else {
                                if (textViewNum2.text.equals("Numero 2")) {
                                    proceso2 = proceso2.plus("-")
                                    textViewNum2.text = proceso2
                                    buttonResta.setEnabled(false);
                                    buttonResta.setBackgroundColor(Color.WHITE)
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Ya no puedes introducir negativos, se desactiva el boton resta",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    buttonResta.setEnabled(false);
                                    buttonResta.setBackgroundColor(Color.WHITE)
                                }
                            }
                        }
                    }
                }
            }

            buttonMult.setOnClickListener {
                signoMult()
            }

            buttonDiv.setOnClickListener {
                signoDiv()
            }

            buttonReinicio.setOnClickListener {
                proceso1 = ""
                proceso2 = ""
                textViewNum1.text = "Numero 1"
                textViewSigno.text = "Signo"
                textViewNum2.text = "Numero 2"
                textViewResultado.text = "Resultado"
                desbloquearSignos()
            }

            buttonIgual.setOnClickListener {
                if (textViewNum1.text.equals("Numero 1") or textViewSigno.text.equals("Signo") or textViewNum2.text.equals(
                        "Numero 2"
                    ) ) {
                    Toast.makeText(
                        this,
                        "No puede pulsar resultado sin haber datos en cada hueco",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (textViewNum2.text.equals("-")) {
                        Toast.makeText(
                            this,
                            "Falta un numero en el segundo hueco",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        when(textViewSigno.text){
                            "+" -> cuentasHorizontal("+")
                            "-" -> cuentasHorizontal("-")
                            "x" -> cuentasHorizontal("x")
                            "/" -> cuentasHorizontal("/")
                        }

                        proceso2 = ""
                        textViewSigno.text = "Signo"
                        textViewNum2.text = "Numero 2"
                        desbloquearSignos()
                    }
                }
            }


        }
    }
}

