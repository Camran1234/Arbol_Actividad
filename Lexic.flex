package com.mycompanyeans.parser;
import static com.mycompanyeans.parser.sym.*;
import java_cup.runtime.*;

%%
%class Lexic
%cup
%unicode
%line
%column
%public

%{

%}

/* REGULAR EXPRESSION */

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator}| [ \t\f]

/*Reserved Words*/
Procedimiento = [p][r][o][c][e][d][i][m][i][e][n][t][o]
Programa = [p][r][o][g][r][a][m][a]
Begin = [b][e][g][i][n]
End = [e][n][d]
Number = [0-9]+
Simbolo = [aA-zZ][[aA-zZ]|[0-9]|[_]|[$]]*
Integer = [i][n][t][e][g][e][r]
Param = [p][a][r][a][m]

%%

<YYINITIAL> {
    /*Simboloes especiales*/
    "(" {System.out.println(yytext()+"\n");;return new Symbol(OPEN_PARENTHESIS, yyline+1, yycolumn+1, yytext());}
    ")" {System.out.println(yytext()+"\n");return new Symbol(CLOSE_PARENTHESIS, yyline+1, yycolumn+1, yytext());}
    ";" {System.out.println(yytext()+"\n");return new Symbol(COLON, yyline+1, yycolumn+1, yytext());}
    ":" {System.out.println(yytext()+"\n");return new Symbol(SEMI_COLON, yyline+1, yycolumn+1, yytext());}
    "=" {System.out.println(yytext()+"\n");return new Symbol(EQUAL, yyline+1, yycolumn+1, yytext());}

    /*Reserved Words*/
    {Integer}  {System.out.println(yytext()+"\n");return new Symbol(INTEGER, yyline+1, yycolumn+1, yytext());}
    {End}   {System.out.println(yytext()+"\n");return new Symbol(END, yyline+1, yycolumn+1, yytext());}
    {Begin} {System.out.println(yytext()+"\n");return new Symbol(BEGIN, yyline+1, yycolumn+1, yytext());}
    {Procedimiento} {System.out.println(yytext()+"\n");return new Symbol(PROCEDIMIENTO, yyline+1, yycolumn+1, yytext());}
    {Param} {System.out.println(yytext()+"\n");return new Symbol(PARAM, yyline+1, yycolumn+1, yytext());}
    {Programa}  {System.out.println(yytext()+"\n");return new Symbol(PROGRAMA, yyline+1, yycolumn+1, yytext());}
    {Number} {System.out.println(yytext()+"\n");return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext());}
    {Simbolo} {System.out.println(yytext()+"\n");return new Symbol(SIMBOLO, yyline+1, yycolumn+1, yytext());}
    

    {WhiteSpace}    {/*Ignore*/}
}

