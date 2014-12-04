CHORDSTARS
==========

## General Things

Check Github Issues to find things to work on.  I'm not going to assign things to people, please just take them and self-assign ones you are working on.  Also please tag whatever you're doing appropriately.

Please make your own branches when you're working on stuff, and when you're ready to push your stuff to master, open a pull request so me/others can review it.  It might be best if I just approve all pull requests for consistency's sake.  This will ensure that we don't accidently break each others' stuff, because the worst possible thing would just be to break everything and try to solve terrible terrible merge conflicts hours before the project is due.

## Working with fragments

I'm not an Android expert by any means, but I thought I might try to add some basic information about fragments.  Android is really confusing and I just want to try to eliminate some googling time.

- Fragments are parts of an activity, and are meant to be easily shuffled in and out.  Fragments are contained in `FrameLayout`s.  To switch fragments, use `FragmentTransaction`s.
- We'll probably have various buttons on each fragment for navigation's sake.  For example, when we select a song, we're probably going to swap fragments to create a `LearnSongFragment` or something like that.  You can add a button and then set an `onClickListener` which can actually swap out the fragments.
- Try to use LinearLayouts for your layout unless you need RelativeLayouts; they tend to be easier to use, more clear and understandable, and in general lead to less pain.  Use FrameLayout if you plan on having nested fragments or something.  I don't think we should need this except for maybe when we're searching for a song.

## Working with intents

I don't have any prior experience with setting up Intents and launching new activities, but if someone does the research, please add information here so we don't have to all waste googling time.  We'll need intents to set up the Download More Songs feature (open the browser pointing to Spotify or something), and the Listen to Song feature (open the Media Player with whatever song)

