#!/bin/bash 
#################################################
#	WHAT is svg2png ?
# Script to convert svg files to png
# svg2png does not modify the file which you select, it creates a new file.
# It cannot convert a directory but you can select several files.

#################################################
#		INFO
# Author : yeKcim - yeknan@yahoo.fr - http://yeknan.free.fr
# Licence : GNU GPL
# Dependency
#		zenity
#		inkscape
# Based on
#		WOM_audioconverter
# History
#		15.01.2006 : v0.1 : First public version
# Install
# 		Put on ~/.gnome2/nautilus-scripts/
#		In a console : chmod u+x ~/.gnome2/nautilus-scripts/svg2png

version="0.1"
#################################################
#	TRADUCTIONS
		###### Default = English #####
		title="svg2png "$version""
		pleasesel="Please select at least one file."
		noselec=""$title" converts svg to png. "$pleasesel""
		nobin="Program inkscape is not installed, please install !"
		warning="Warning"
		choix="Export type ?"
		drawing="Drawing"
		canvas="Canvas"
		exportof="Picture to convert :"
	case $LANG in
		######## FranÃ§ais ########
		fr* )
		title="svg2png "$version""
		pleasesel="Merci de sÃ©lectionner au moins un fichier."
		noselec=""$title" permet de convertir des svg en png. "$pleasesel""
		warning="Attention"
		nobin="Le programme inkscape n'est pas installÃ©, veuillez l'installer !"
		choix="Type d'export ?"
		drawing="Dessin"
		canvas="Page"
		exportof="Image Ã  convertir :" ;;
	esac

#################################################
#	PROGRAMME
######## Test dÃ©pendance ########
which inkscape 2>/dev/null
if [ $? != 0 ]
then
	zenity --error --title="$title" --text="$nobin"
	exit 0
fi

#### Pas de fichiers sÃ©lectionnÃ© ###
if [ $# -eq 0 ]; then
	zenity --error --title="$warning" --text="$noselec"
	exit 1
fi

######## Page/image ? ########
while [ ! "$choixutilisateur" ] # RÃ©afficher la fenÃªtre tant que l'utilisateur n'a pas fait de choix
do
	choixutilisateur=`zenity --title "$title" --list --column="$exportof" $canvas $drawing --text "$choix"`
	###### Choix -> Sortie boucle ######
	if  [ $? != 0 ]; then
		exit 1
	fi
	[ $? -ne 0 ] && exit 2 # Annulation
done

if  [ $choixutilisateur == $drawing ]; then
	type="--export-area-drawing";
fi

######## RÃ©solution ? ########
while [ ! "$resolution" ] # RÃ©afficher la fenÃªtre tant que l'utilisateur n'a pas fait de choix
do
	resolution=`zenity --entry --title "$title" --text "RÃ©solution :" --entry-text "90"`
	###### Choix -> Sortie boucle ######
	if  [ $? != 0 ]; then
		exit 1
	fi
	[ $? -ne 0 ] && exit 2 # Annulation
done

######## Export png ########
while [ $# -gt 0 ]; do
	picture=$1
	png_file=`echo "$picture" | sed 's/\.\w*$/.png/'`
	inkscape $type --export-dpi="$resolution" --export-png="$png_file" "$picture"
	shift
done