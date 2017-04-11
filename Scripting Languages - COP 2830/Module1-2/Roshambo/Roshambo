import random
from tkinter import *
from tkinter import ttk

print("----------------------------------------------\n"
      "_.-*'*-.__.-*'*-._ Roshambo _.-*'*-.__.-*'*-._\n"
      "----------------------------------------------\n")


def play():
    # print("----------------------------------------------")
    # print("What's your play?")

    # Add choices to array for iteration.
    player_choices = [hand1.get(), hand2.get()]

    # Add label text to array for iteration.
    label_texts = [hand1a_results_text, hand2a_results_text, hand1b_results_text, hand2b_results_text]

    # i = 0
    # while i < 2:
    #    print("Hand #{}".format(i + 1))
    #    player_choices[i] = int(input("Rock (1), Paper (2), or Scissors (3)?\n"))
    #    i += 1
    opponent_choices = [random.randint(1, 3), random.randint(1, 3)]

    # Iteration count.
    i = 0

    # Start choice iterations.
    for choice in player_choices:

        # Game logic.
        if player_choices[i] == opponent_choices[i]:
            label_texts[i].set("You both chose the same thing for Hand #{}.".format(i + 1))
            label_texts[i + 2].set("It's a draw!\n")
            # print("You both chose the same thing for Hand #{}.".format(i + 1))
            # print("It's a draw!\n")
        else:
            if player_choices[i] == 1:
                if opponent_choices[i] == 3:
                    label_texts[i].set("Opponent chose Scissors.")
                    label_texts[i + 2].set("Hand #{} Won!\n".format(i + 1))
                    # print("Opponent chose Scissors.")
                    # print("Hand #{} Won!\n".format(i + 1))
                else:
                    label_texts[i].set("Opponent chose Paper.")
                    label_texts[i + 2].set("Sorry, Hand #{} Lost!\n".format(i + 1))
                    # print("Opponent chose Paper.")
                    # print("Sorry, Hand #{} Lost!\n".format(i + 1))
            elif player_choices[i] == 2:
                if opponent_choices[i] == 1:
                    label_texts[i].set("Opponent chose Rock.")
                    label_texts[i + 2].set("Hand #{} Won!\n".format(i + 1))
                    # print("Opponent chose Rock.")
                    # print("Hand #{} Won!\n".format(i + 1))
                else:
                    label_texts[i].set("Opponent chose Scissors.")
                    label_texts[i + 2].set("Sorry, Hand #{} Lost!\n".format(i + 1))
                    # print("Opponent chose Scissors")
                    # print("Sorry, Hand #{} Lost!\n".format(i + 1))
            elif player_choices[i] == 3:
                if opponent_choices[i] == 2:
                    label_texts[i].set("Opponent chose Paper.")
                    label_texts[i + 2].set("Hand #{} Won!\n".format(i + 1))
                    # print("Opponent chose Paper")
                    # print("Hand #{} Won!\n".format(i + 1))
                else:
                    label_texts[i].set("Opponent chose Rock.")
                    label_texts[i + 2].set("Sorry, Hand #{} Lost!\n".format(i + 1))
                    # print("Opponent chose Rock.")
                    # print("Sorry, Hand #{} Lost!\n".format(i + 1))
        i += 1


def build_gui():
    # Window source.
    root = Tk()
    root.title("Roshambo")

    # Main GUI window.
    window = ttk.Frame(root, padding="3 3 12 12")
    window.grid(column=4, row=3, sticky=(N, W, E, S))
    window.columnconfigure(0, weight=1)
    window.rowconfigure(0, weight=1)

    # Window Label
    window_label_text = StringVar()
    window_label_text.set(
        "----------------------------------------------\n"
        "_.-*'*-.__.-*'*-._ Roshambo _.-*'*-.__.-*'*-._\n"
        "----------------------------------------------\n")
    window_label = Label(window, textvariable=window_label_text).grid(column=0, row=0, columnspan=5, sticky=W)

    # Hand 1
    # Label
    hand1_label_text = StringVar()
    hand1_label_text.set("Hand 1: ")
    hand1_label = Label(window, textvariable=hand1_label_text).grid(column=1, row=1, sticky=W)

    # Radio Buttons
    global hand1
    hand1 = IntVar()
    hand1_button1 = Radiobutton(window, text="Rock", variable=hand1, value=1).grid(column=2, row=1, sticky=W)
    hand1_button2 = Radiobutton(window, text="Paper", variable=hand1, value=2).grid(column=3, row=1, sticky=W)
    hand1_button3 = Radiobutton(window, text="Scissors", variable=hand1, value=3).grid(column=4, row=1, sticky=W)

    # Hand 2
    # Label
    hand2_label_text = StringVar()
    hand2_label_text.set("Hand 2: ")
    hand2_label = Label(window, textvariable=hand2_label_text).grid(column=1, row=2, sticky=W)

    # Radio Buttons
    global hand2
    hand2 = IntVar()
    hand2_button1 = Radiobutton(window, text="Rock", variable=hand2, value=1).grid(column=2, row=2, sticky=W)
    hand2_button2 = Radiobutton(window, text="Paper", variable=hand2, value=2).grid(column=3, row=2, sticky=W)
    hand2_button3 = Radiobutton(window, text="Scissors", variable=hand2, value=3).grid(column=4, row=2, sticky=W)

    # Play Button
    play_button = Button(window, text="Play!", command=play).grid(column=0, row=3, columnspan=5)

    # Game Results Labels
    global hand1a_results_text
    hand1a_results_text = StringVar()
    hand1a_results_text.set("")
    global hand1b_results_text
    hand1b_results_text = StringVar()
    hand1b_results_text.set("")
    global hand2a_results_text
    hand2a_results_text = StringVar()
    hand2a_results_text.set("")
    global hand2b_results_text
    hand2b_results_text = StringVar()
    hand2b_results_text.set("")

    hand1a_result_label = Label(window, textvariable=hand1a_results_text).grid(column=0, row=4, columnspan=5)
    hand1b_result_label = Label(window, textvariable=hand1b_results_text).grid(column=0, row=5, columnspan=5)
    hand2a_result_label = Label(window, textvariable=hand2a_results_text).grid(column=0, row=6, columnspan=5)
    hand2b_result_label = Label(window, textvariable=hand2b_results_text).grid(column=0, row=7, columnspan=5)

    # Show window
    window.mainloop()


# Establish GUI
build_gui()
