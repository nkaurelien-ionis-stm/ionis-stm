from tkinter import *
from Shadow import Shadow


# INIT GUI -------------

fenetre = Tk()
fenetre.title("Calcul de mensualité")
fenetre.geometry("600x500")

# ELEMENTS ----------------------------

lblResult = Label(fenetre, text="", pady=20)

# FUNCTION ----------------------------

#cliquer sur le button
def calculMensualite():
    credit    =(float)(inputCredit.get())
    taux      =(float)(inputTaux.get())
    duree     =(float)(inputRemboursement.get())

    taux = taux / 100

    n1 = credit * taux / 12

    n2 = 1 - pow((1+taux/12), -1 * duree * 12)

    RESULT= round(n1/n2)

    #résultat dans un label sur GUI
    lblResult.config(text="MONTANT ESTIME DE VOTRE MENSUALITE : "+ str(RESULT) + " EUR/MOIS")
    #   #résultat par pop-up
    #   top= Toplevel(fenetre)
    #   top.geometry("300x100")
    #   top.title("Résultat")
    #   Label(top,text= str(result), font=('Mistral 18 bold')).place(x=20,y=10)


# BEGIN ----------------------------


# Row1

lblCredit = Label(fenetre, text="Montant du credit")
lblCredit.pack()
inputCredit = Entry(fenetre, width=30)
inputCredit.insert(0,"250000") 
inputCredit.pack()

# Row2

lblTaux = Label(fenetre, text="Taux")
lblTaux.pack()
inputTaux = Entry(fenetre, width=30)
inputTaux.insert(0,"2.1") 
inputTaux.pack()

# Row3
frameRemboursement = Frame(fenetre, background="red")
lblRemboursement = Label(fenetre, text="Duree de Remboursement (an)")
lblRemboursement.pack()
inputRemboursement = Entry(frameRemboursement, width=30)
inputRemboursement.insert(0,"20") 
inputRemboursement.pack(padx=1, pady=1)
frameRemboursement.pack(padx=20, pady=20)

# Row4

btnRun=Button(fenetre, text="VOTRE RESULTAT", padx=5, pady=10, foreground="white", background="#6ecbde",borderwidth=0 )
# Shadow(btnRun)
btnRun.pack()
# Shadow(btnRun, color='#ff0000', size=1.3, offset_x=-5, onclick={'color':'#00ff00'})
btnRun.config(command=calculMensualite)

# Row4
lblResult.config(foreground="#91c33f")
lblResult.pack()

fenetre.mainloop()