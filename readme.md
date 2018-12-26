# Agoogol

## Requirements

- [Clojure Tools](https://clojure.org/guides/getting_started)

It's also good to install `rlwrap`:

- Easiest on Mac is to use Homebrew: `brew install rlwrap`
- On Linux use your package manager. On Debian: `apt install rlwrap`

## Run the Experiments

### Experiment 1 - The English Alphabet

`clojure -A:experiment1`

- *input*: `./inputs/alphabet.txt`
- *output*: `./outputs/alphabet.csv`

### Experiment 2 - A Sample Corpus

`clojure -A:experiment2`

- *input*: `./inputs/corpus-test.txt`
- *output*: `./outputs/corpus-test.csv`

### Experiment 3 - A Sample Corpus transformed with Pig Latin

`clojure -A:experiment3`

- *input*: `./inputs/corpus-test.txt`
- *output*: `./outputs/corpus-test-pig-latin.csv`

### Experiment 4 - A Sample Corpus - testing success with `Did you mean?`

`clojure -A:experiment4`

- *input*: `./inputs/corpus-test.txt`
- *output*: `./outputs/corpus-test-did-you-mean.csv`

### Experiment 5 - A Sample Corpus transformed with Pig Latin - testing success with `Did you mean?`

`clojure -A:experiment5`

- *input*: `./inputs/corpus-test.txt`
- *output*: `./outputs/corpus-test-pig-latin-did-you-mean.csv`
