#Select Random Opponent for Game Club
#Author: Adrian Aleman

import random

gameClub = ["Ryan W", "Victor", "Arley", "William", "Ethan", "Tim", "Mr. Aleman"]
t = input("Enter your code: ")

def opponentPicker(gameClub):
	while t == 'tiger':
		name = input("Y/N for opponent: ")
		if name == 'y' or name == 'Y':
			nameSelected = random.choice(gameClub)
			print(nameSelected)
			gameClub.remove(nameSelected)
			if gameClub == []:
				gameClub = ["Ryan W", "Victor", "Arley", "William", "Ethan", "Tim", "Mr. Aleman"]
		elif name == 'n' or name == 'N':
			print("come again soon!")
			break
		elif name != 'y' and name != 'n':
			print("Sorry, that entry is invalid. Please enter in Y/N format.")
		
opponentPicker(gameClub)
print("Game Club is over. Thank you for playing!")
